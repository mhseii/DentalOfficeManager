package br.com.dentalofficemanager.entity;

import java.math.BigDecimal;
import java.util.Calendar;

public class Payment {

	private Long id;
	private Long dentalRecordId;
	private Calendar paymenteDate;
	private BigDecimal amountPaid;
	private String paymentDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDentalRecordId() {
		return dentalRecordId;
	}

	public void setDentalRecordId(Long dentalRecordId) {
		this.dentalRecordId = dentalRecordId;
	}

	public Calendar getPaymenteDate() {
		return paymenteDate;
	}

	public void setPaymenteDate(Calendar paymenteDate) {
		this.paymenteDate = paymenteDate;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

}
