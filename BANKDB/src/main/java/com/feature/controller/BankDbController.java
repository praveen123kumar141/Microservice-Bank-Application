package com.feature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.feature.Service.BankDBServiceInterface;
import com.feature.entity.Bankdatabase;


@RestController
public class BankDbController {
	
	@Autowired
	private BankDBServiceInterface bs;
	
	@PostMapping("/create_new_customer")
	public Bankdatabase createnewCustomer(@RequestBody Bankdatabase ob) throws Exception {
		Bankdatabase response = bs.createNewCustome(ob);
		return response;
	}
	
	@GetMapping("/getcustomer/{id}")
	public Bankdatabase getcustomer(@PathVariable String id)throws Exception {
		Bankdatabase customerdetails = bs.getcustomerdetails(id);
		return customerdetails;
	}
	@PutMapping("/updateinternet_bank_status")
	public Bankdatabase updateInternetbankStatus(@RequestBody Bankdatabase ob)throws Exception {
		return bs.updateInternetBankStstus(ob);
	}
	/*@PutMapping("/adding_Payee")
	public String addingPayee(@RequestBody Bankdatabase ob)throws Exception{
		return bs.addPayee(ob);
	}*/
	@GetMapping("/getcustomerBYacno/{id}")
	public Bankdatabase getcustomerByAcno(@PathVariable String id)throws Exception {
		Bankdatabase customerdetails =bs.getCustomerdetailsByacno(id);
		return customerdetails;
	}
	@PutMapping("/updatecustomerdetails")
	public Bankdatabase updatecustomerdetails(@RequestBody Bankdatabase ob) throws Exception {
		return bs.updatecustomerdetails(ob);
	}
}
