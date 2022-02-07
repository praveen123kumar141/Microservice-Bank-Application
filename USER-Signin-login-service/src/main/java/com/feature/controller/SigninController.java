package com.feature.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feature.entity.UserSignin;
import com.feature.service.UserService;

@RestController
public class SigninController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/signin")
	public String signinInternetBank(@Valid@RequestBody UserSignin ob)throws Exception {
		return us.signinInternetBank(ob);
	}

}
