package com.feature.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
		model.put("location", "Bangalore,India");
		return es.sendEmail(request, model);
	}


}
