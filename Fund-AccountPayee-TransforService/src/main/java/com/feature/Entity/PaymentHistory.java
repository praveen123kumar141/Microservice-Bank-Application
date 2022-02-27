package com.feature.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="PAYMENT_HISTORY")
public class PaymentHistory {
	
	@Id
	@Column(name="UTR_NO")
	private String utrnumber;
	
	@Column(name="REMITTER_AC")
	private String remitter_ac;
	
	@Column(name="BENEFICIARY_AC")
	private String benefi_ac;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="RESON")
	private String resion;
	
	@Column(name="TRANSACTION_STATUS")
	private String trans_status;
	
	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate creatinData;

	public String getUtrnumber() {
		return utrnumber;
	}

	public void setUtrnumber(String utrnumber) {
		this.utrnumber = utrnumber;
	}

	public String getRemitter_ac() {
		return remitter_ac;
	}

	public void setRemitter_ac(String remitter_ac) {
		this.remitter_ac = remitter_ac;
	}

	public String getBenefi_ac() {
		return benefi_ac;
	}

	public void setBenefi_ac(String benefi_ac) {
		this.benefi_ac = benefi_ac;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getResion() {
		return resion;
	}

	public void setResion(String resion) {
		this.resion = resion;
	}

	public String getTrans_status() {
		return trans_status;
	}

	public void setTrans_status(String trans_status) {
		this.trans_status = trans_status;
	}

	public LocalDate getCreatinData() {
		return creatinData;
	}

	public void setCreatinData(LocalDate creatinData) {
		this.creatinData = creatinData;
	}
	
	
	
}
