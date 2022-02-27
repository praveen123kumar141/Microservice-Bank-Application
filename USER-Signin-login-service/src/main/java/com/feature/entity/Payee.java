package com.feature.entity;

public class Payee {
	
	
	private String payeeId;
	private String PayeeName;
	private String PayeeAccNo;
	private String payeeIfscCode;
	private String typeOfAc;
	private transient String CUser_id;
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
