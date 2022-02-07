package com.feature.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feature.entity.Bankdatabase;
import com.feature.entity.MailRequest;
import com.feature.repository.BankDbRepo;

@Service
public class BankDBServiceImplementation implements BankDBServiceInterface {

	@Autowired 
	private BankDbRepo bdr;
	

	
	RestTemplate restTemplate = new RestTemplate();
	MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	
	public BankDBServiceImplementation() {
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
	}
	
	 
	
	@Override
	public Bankdatabase createNewCustome(Bankdatabase ob)throws URISyntaxException
	{
		 String url="http://localhost:8090/sendingEmail";
		// TODO Auto-generated method stub
		if(ob!=null) {
			ob.setAccStatus("ACTIVE");
			ob.setBankAddr("Vijayawada");
			ob.setInternet_bank_status("INACTIVE");
			long id= 1724001234;
			List<Bankdatabase> findAll = bdr.findAll();
			int size = findAll.size();
			if(size==0) {
				String ac="10201"+id;
				ob.setAcNo(ac);
			}else {
					id=id+size;
					String ac="10201"+id;
					ob.setAcNo(ac);
			}
			bdr.save(ob);
			MailRequest req=new MailRequest();
			req.setFrom("natanipraveenkumar@gmail.com");
			req.setName(ob.getUserName());
			req.setTo(ob.getEmail());
			req.setSubject("Bank Account status");
			this.restTemplate.postForEntity(url,req,String.class);
			return ob;
		}
		return null;
	}



	@Override
	public Bankdatabase getcustomerdetails(String id) throws Exception {
		// TODO Auto-generated method stub
		if(	bdr.existsById(id)) {
		Bankdatabase bankdatabase = bdr.findById(id).get();
		return bankdatabase;
		}else {
		Bankdatabase ob =new Bankdatabase();
		return ob;
		}
	}



	@Override
	public Bankdatabase updateInternetBankStstus(Bankdatabase ob) throws Exception {
		// TODO Auto-generated method stub
		Bankdatabase save = bdr.save(ob);
		return save;
	}



	
}
