package com.feature.service;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feature.entity.Bankdatabase;
import com.feature.entity.UserSignin;
@Service
public class UserServiceImplementation implements UserService {
	

	RestTemplate restTemplate = new RestTemplate();
	MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	
	public UserServiceImplementation() {
	
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		
	}
	@Override
	public String signinInternetBank(UserSignin ob) throws Exception {
		// TODO Auto-generated method stub
		
		String s=ob.getUserId();
		String geturi="http://localhost:8070/getcustomer/"+s;
		String puturi="http://localhost:8070/updateinternet_bank_status";
		Bankdatabase body = this.restTemplate.getForEntity(geturi,Bankdatabase.class,s).getBody();
		if(body.getUserId()!=null) {
		if((body.getDob().toString().equals(ob.getDob().toString()))
				&& (body.getUserId().toString().equals(ob.getUserId().toString()))
				&& (body.getEmail().toString().equals(ob.getEmail().toString()))
				&& (body.getGovidproof().toString().equals(ob.getGovidproof().toString())))
			
		{	
			
			if(body.getInternet_bank_status().equals("ACTIVE")) {
				return "YOU REGISTER FOR INTERNETBANKING";
			}else {
					body.setInternet_bank_status("ACTIVE");
					this.restTemplate.put(puturi,body);
					return "YOU HAVR SUCCESSFULLY REGISTERD FOR INTERNET BANKING";
					
				}
		}else {
		return "YOU PROVIDED INCURRECT DETAILS";
		}
		}
		else {
			return "USER ID IS IN CURRECT";
		}
	}

}
