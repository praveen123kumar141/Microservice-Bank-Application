package com.feature.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feature.service.EmailService;
import com.feature.entity.MailRequest;
@RestController
public class MailSendController {	
	@Autowired
	private EmailService es;
	
	@PostMapping("/sendingEmail")
	public String sendEmail(@RequestBody MailRequest request) {
		System.out.println(request.toString());
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		return es.sendEmail(request, model);
	}
	@PostMapping("/sendingEmailInternet_Bank_Service")
	public String sendEmailinternetbanking(@RequestBody MailRequest request) {
		System.out.println(request.toString());
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		return es.sendEmailintbank(request, model);
	}
	@PostMapping("/sendotp")
	public String sendotp(@RequestBody MailRequest request) {
		System.out.println(request.toString());
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		String otp=es.generateotp();
		model.put("Otp",otp );
		String s=es.sendotp(request, model)+" "+otp;
		return s;
	}
	
	@PostMapping("/paymentcomformation/{ob}")
	public String paymentConform(@RequestBody MailRequest request,@PathVariable("ob") String ob ) {
		System.out.println(request.toString());
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		String[] split = ob.split(" ");
		model.put("debitamount",split[0]);
		model.put("avilablebal", split[1]);
		String response=es.paymentconformation(request,model);
		
		return response;
	}
	


}
