package com.feature.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feature.Entity.Bankdatabase;
import com.feature.Entity.PaymentHistory;
import com.feature.Repository.PaymentHistoryRepo;
import com.feature.Entity.MailRequest;


@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService{

	@Autowired
	private PaymentHistoryRepo phr;
	
	
	RestTemplate restTemplate = new RestTemplate();
	MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	
	public PaymentHistoryServiceImpl() {
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
	}
	
	@Override
	public String transaction(PaymentHistory ob) throws Exception {
		// TODO Auto-generated method stub
		 String url="http://localhost:8090/sendotp";
		 String acno= ob.getRemitter_ac();
		 String geturi="http://localhost:8070/getcustomerBYacno/"+acno;
		 String puturi="http://localhost:8070/updatecustomerdetails";
		 Bankdatabase body = this.restTemplate.getForEntity(geturi,Bankdatabase.class,acno).getBody();
		 MailRequest req=new MailRequest();
		 req.setName(body.getUserName());
		 req.setFrom("natanipraveenkumar@gmail.com");
		 req.setTo(body.getEmail());
		 req.setSubject("ONE TIME OTP ");
		 String body2 = this.restTemplate.postForEntity(url, req,String.class).getBody();//otp sent
		 String[] spl = body2.split(" ");
		 System.out.println("split result"+spl.length);
		 body.setPin(spl[spl.length-1]);
		 this.restTemplate.put(puturi, body);
		
		 //generate utrnumber
		 
		 int utr=1000001;
		 int size = phr.findAll().size();
		 if(size==0) {
			 String utrno="UTR"+utr;
			 ob.setUtrnumber(utrno);
		 }else {
			 utr=phr.findAll().size()+utr;
			 String utrno="UTR"+utr;
			 ob.setUtrnumber(utrno);
		 }
		 ob.setTrans_status("INCOMPLETE");
		 phr.save(ob);
		return "OTP SENT TO YOUR REGISTERD EMAIL TO COMPLETE THE TRANSACTION USE THAT OTP";
	}

	@Override
	public String transforConformation(String rac, String otp, String utrno) throws Exception {
		// TODO Auto-generated method stub
		
		 String geturi="http://localhost:8070/getcustomerBYacno/"+rac;
		 String puturi="http://localhost:8070/updatecustomerdetails";
		 
		 //retriving remitter account details 
		 Bankdatabase body = this.restTemplate.getForEntity(geturi,Bankdatabase.class,rac).getBody();
		 
		 if(body.getPin().equals(otp)) {
			 
			 PaymentHistory paymentHistory = phr.findById(utrno).get();
			 paymentHistory.setTrans_status("COMPLETED");
			phr.saveAndFlush(paymentHistory);
			System.out.println(body);
			long debitamount=(long)paymentHistory.getAmount();
			long benbal=body.getBalence();
			long benfinalbal=benbal-debitamount;
			body.setBalence(benfinalbal);
			
			if(debitamount< benbal) {
			
			//update remutter account details
			
			this.restTemplate.put(puturi, body);
			
			 MailRequest req=new MailRequest();
			 req.setName(body.getUserName());
			 req.setFrom("natanipraveenkumar@gmail.com");
			 req.setTo(body.getEmail());
			 req.setSubject("PayMent CONFORMATION");
			 
			 
				/*
				 * Map<String, Object> model = new HashMap<>();
				 * model.put("debitamount",paymentHistory.getAmount());
				 * model.put("avilablebal",body.getBalence()-(long)paymentHistory.getAmount());
				 */
			 String s=String.valueOf(debitamount)+" "+String.valueOf(benfinalbal);
			 //email for paymemt conformation
			 
			 String emailconformuri="http://localhost:8090/paymentcomformation/"+s;
			
			 String body2 = this.restTemplate.postForEntity(emailconformuri, req, String.class, s).getBody();
		
			 //adding amount to benficiry account
			 String geturiben="http://localhost:8070/getcustomerBYacno/"+paymentHistory.getBenefi_ac();
			 Bankdatabase body3 = this.restTemplate.getForEntity(geturiben,Bankdatabase.class,paymentHistory.getBenefi_ac()).getBody();
			 body3.setBalence(body3.getBalence()+(long)paymentHistory.getAmount());
			 
			 this.restTemplate.put(puturi, body3);
			 
			 return "TRANSACTION IS COMPLETED";
		 }else {
			 return "INSUFFICENT BALENCE";
		 }
		 
		return "OTP IS IN CURRECT";
	}

	

}
