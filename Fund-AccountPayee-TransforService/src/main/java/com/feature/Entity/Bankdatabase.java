package com.feature.Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;



public class Bankdatabase {
	
	
	private String userId;

	private String userName;
	
	
	private String acNo;
	

	private String ifscCode; 
	
	
	private Long balence;
	

	private String email;
	

	private String mobileNo;
	
	
	private String bankAddr;
	
	
	private String accStatus;
	

	private String accType;
	

	private String custAddr;
	

	private LocalDate dob;
	
	
	private String govidproof;
	
	
	private LocalDate creatinData;

	private LocalDate latUpdatedDate;
	
	private String internet_bank_status;
	
	private Set<Payee> payee;
	
	private String pin;
	
	
	

	public Set<Payee> getPayee() {
		return payee;
	}

	public void setPayee(Set<Payee> payee) {
		this.payee = payee;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getInternet_bank_status() {
		return internet_bank_status;
	}

	public void setInternet_bank_status(String internet_bank_status) {
		this.internet_bank_status = internet_bank_status;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGovidproof() {
		return govidproof;
	}

	public void setGovidproof(String govidproof) {
		this.govidproof = govidproof;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAcNo() {
		return acNo;
	}

	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Long getBalence() {
		return balence;
	}

	public void setBalence(Long balence) {
		this.balence = balence;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getBankAddr() {
		return bankAddr;
	}

	public void setBankAddr(String bankAddr) {
		this.bankAddr = bankAddr;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public LocalDate getCreatinData() {
		return creatinData;
	}

	public void setCreatinData(LocalDate creatinData) {
		this.creatinData = creatinData;
	}

	public LocalDate getLatUpdatedDate() {
		return latUpdatedDate;
	}

	public void setLatUpdatedDate(LocalDate latUpdatedDate) {
		this.latUpdatedDate = latUpdatedDate;
	}

	@Override
	public String toString() {
		return "Bankdatabase [userId=" + userId + ", userName=" + userName + ", acNo=" + acNo + ", ifscCode=" + ifscCode
				+ ", balence=" + balence + ", email=" + email + ", mobileNo=" + mobileNo + ", bankAddr=" + bankAddr
				+ ", accStatus=" + accStatus + ", accType=" + accType + ", custAddr=" + custAddr + ", dob=" + dob
				+ ", govidproof=" + govidproof + ", creatinData=" + creatinData + ", latUpdatedDate=" + latUpdatedDate
				+ ", internet_bank_status=" + internet_bank_status + ", payee=" + payee + ", pin=" + pin + "]";
	}

	

	

	
	

}
