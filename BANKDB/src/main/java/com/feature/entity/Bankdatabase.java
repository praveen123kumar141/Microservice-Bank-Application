package com.feature.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.feature.generators.UserIdGenerator;

@Entity //normal java class treated it as a database table
@Table(name = "BANKDB")
public class Bankdatabase {
	
	@Id() //primry key
	@Column(name="USERID") //setting thr column name 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id")
	@GenericGenerator(name="user_id",strategy ="com.feature.generators.UserIdGenerator",
	parameters = {
			@Parameter(name=UserIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name=UserIdGenerator.VALUE_PREFIX_PARAMETER,value="FECUID"),
			@Parameter(name=UserIdGenerator.NUMBER_FORMAT_PARAMETER,value="%05d")
			
	})
	
	private String userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="Account")
	private String acNo;
	
	@Column(name="IFSC_CODE")
	private String ifscCode="FECA002304"; 
	
	@Column(name="BALENCE")
	private Long balence;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="BRANCH_ADDR")
	private String bankAddr;
	
	@Column(name="ACCOUNT_STATUS")
	private String accStatus;
	
	@Column(name="ACCOUNT_TYPE")
	private String accType;
	
	@Column(name="CUSTOMER_ADDR")
	private String custAddr;
	
	@Column(name="DATE_OF_BIRTH")
	private LocalDate dob;
	
	@Column(name="GOV_ID_PROOF")
	private String govidproof;

	@Column(name="CREATE_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate creatinData;
	
	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate latUpdatedDate;
	
	@Column(name="INTERNET_BANKING_STATUS")
	private String internet_bank_status;

	
	
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






	public String getInternet_bank_status() {
		return internet_bank_status;
	}



	public void setInternet_bank_status(String internet_bank_status) {
		this.internet_bank_status = internet_bank_status;
	}



	@Override
	public String toString() {
		return "Bankdatabase [userId=" + userId + ", userName=" + userName + ", acNo=" + acNo + ", ifscCode=" + ifscCode
				+ ", balence=" + balence + ", email=" + email + ", mobileNo=" + mobileNo + ", bankAddr=" + bankAddr
				+ ", accStatus=" + accStatus + ", accType=" + accType + ", custAddr=" + custAddr + ", creatinData="
				+ creatinData + ", latUpdatedDate=" + latUpdatedDate + ", internet_bank_status=" + internet_bank_status
				+ "]";
	}
	
	

}
