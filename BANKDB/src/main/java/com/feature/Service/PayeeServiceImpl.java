package com.feature.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feature.entity.Bankdatabase;
import com.feature.entity.Payee;
import com.feature.repository.BankDbRepo;
import com.feature.repository.PayeeRepository;

@Service
public class PayeeServiceImpl implements PayeeService {

	@Autowired
	private BankDbRepo bdr;
	
	@Autowired
	private PayeeRepository pr;
	
	@Override
	public String addPayee(Payee ob) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("before pid**************************");
		Bankdatabase  cus_record= bdr.findById(ob.getCUser_id()).get();
		int pid = cus_record.getPayee().size()+
				Integer.parseInt(
						cus_record.getAcNo().substring(
						cus_record.getAcNo().length()-4,
						cus_record.getAcNo().length()));
		System.out.println("after pid**************************");
		/*int pid = Integer.parseInt(
				cus_record.getAcNo().substring(
				cus_record.getAcNo().length()-4,
				cus_record.getAcNo().length()));*/
		
		ob.setPayeeId("PID"+pid);
		ob.setBankdbrec(cus_record);
		pr.save(ob);
		return "Payee added successfully";
	}

	@Override
	public String deletePayee(String cus_user_id, String payee_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
