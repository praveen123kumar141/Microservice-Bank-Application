package com.feature.service;

import com.feature.Entity.PaymentHistory;

public interface PaymentHistoryService {
	
	public String transaction(PaymentHistory ob)throws Exception;
	public String transforConformation(String rac,String otp,String utrno)throws Exception;

}
