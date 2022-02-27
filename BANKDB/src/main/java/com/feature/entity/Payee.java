package com.feature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Payee {
	@Id
	@Column(name="PAYEE_ID")
	private String payeeId;
	
	@Column(name="PAYEE_NAME")
	private String PayeeName;
	
	@Column(name="PAYEE_ACC_NO")
	private String PayeeAccNo;
	
	@Column(name="PAYEE_IFSC_CODE")
	private String payeeIfscCode;
	
	@Column(name="TYPE_OF_ACCOUNT")
	private String typeOfAc;
	
	private transient String CUser_id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	 //@JoinColumn(name = "customer_id")
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Bankdatabase bankdbrec;
	
	
	
	public String getCUser_id() {
		return CUser_id;
	}
	public void setCUser_id(String cUser_id) {
		CUser_id = cUser_id;
	}
	public Bankdatabase getBankdbrec() {
		return bankdbrec;
	}
	public void setBankdbrec(Bankdatabase bankdbrec) {
		this.bankdbrec = bankdbrec;
	}
	public String getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeeName() {
		return PayeeName;
	}
	public void setPayeeName(String payeeName) {
		PayeeName = payeeName;
	}
	public String getPayeeAccNo() {
		return PayeeAccNo;
	}
	public void setPayeeAccNo(String payeeAccNo) {
		PayeeAccNo = payeeAccNo;
	}
	public String getPayeeIfscCode() {
		return payeeIfscCode;
	}
	public void setPayeeIfscCode(String payeeIfscCode) {
		this.payeeIfscCode = payeeIfscCode;
	}
	public String getTypeOfAc() {
		return typeOfAc;
	}
	public void setTypeOfAc(String typeOfAc) {
		this.typeOfAc = typeOfAc;
	}
	
	
}
