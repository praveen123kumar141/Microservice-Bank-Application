package com.feature.Service;

import java.net.URISyntaxException;

import com.feature.entity.Bankdatabase;

public interface BankDBServiceInterface {
	
	public Bankdatabase createNewCustome(Bankdatabase ob)throws URISyntaxException;
	
	public Bankdatabase getcustomerdetails(String id)throws Exception;
	
	public Bankdatabase updateInternetBankStstus(Bankdatabase ob) throws Exception;

}
