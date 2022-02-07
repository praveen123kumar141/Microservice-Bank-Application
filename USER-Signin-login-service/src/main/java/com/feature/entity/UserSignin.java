package com.feature.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserSignin {
	
	@NotBlank(message="UserId is mandatory")
	private String userId;
	@NotBlank(message="Email is mandatory")
	private String email;
	@NotBlank(message="govidproof is mandatory")
	private String govidproof;
	@NotNull
	private LocalDate dob;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGovidproof() {
		return govidproof;
	}
	public void setGovidproof(String govidproof) {
		this.govidproof = govidproof;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
}
