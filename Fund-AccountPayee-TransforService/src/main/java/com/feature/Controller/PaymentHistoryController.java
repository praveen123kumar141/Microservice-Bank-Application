package com.feature.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feature.Entity.PaymentHistory;
import com.feature.Entity.PaymetValidation;
import com.feature.service.PaymentHistoryService;

@RestController
public class PaymentHistoryController {
	
	@Autowired
	private PaymentHistoryService phs;
	
	@PostMapping("/transfor")
	public String transforAmount(@RequestBody PaymentHistory ob)throws Exception{
		String transaction = phs.transaction(ob);
		return transaction;
	}
	
	@PostMapping("/Transforcomformation")
	public String  transforconformation(@RequestBody PaymetValidation pv) throws Exception {
		
		String transforConformation = phs.transforConformation(pv.getRac(),pv.getOtp(),pv.getUtr());
		
		return transforConformation;
	}
	
}
