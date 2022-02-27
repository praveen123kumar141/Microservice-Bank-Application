package com.feature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feature.Service.PayeeService;
import com.feature.entity.Payee;

@RestController
public class PayeeController {
	
	@Autowired
	private PayeeService ps;
	
	@PostMapping("/add-new-payee")
	public String addpayee(@RequestBody Payee ob) throws Exception {
		String response = ps.addPayee(ob);
		return response;
	}
	

}
