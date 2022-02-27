package com.feature.Service;

import java.net.URISyntaxException;

import com.feature.entity.Bankdatabase;

public interface BankDBServiceInterface {
	
	public Bankdatabase createNewCustome(Bankdatabase ob)throws URISyntaxException;
	
	public Bankdatabase getcustomerdetails(String id)throws Exception;
	
	public Bankdatabase updateInternetBankStstus(Bankdatabase ob) throws Exception;
	//public String addPayee(Bankdatabase ob)throws Exception;
	public Bankdatabase getCustomerdetailsByacno(String acno)throws Exception;
	public Bankdatabase updatecustomerdetails(Bankdatabase ob)throws Exception;
}
