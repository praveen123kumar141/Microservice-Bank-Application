package com.feature.Service;

import com.feature.entity.Payee;

public interface PayeeService {
	
	public String addPayee(Payee ob) throws Exception;
	public String deletePayee(String cus_user_id,String payee_id)throws Exception;
}
