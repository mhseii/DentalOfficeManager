package br.com.dentalofficemanager.entity;

import java.math.BigDecimal;
import java.util.Calendar;

public class DentalProceedings {

	private Long id;
	private Long dentalRecordId;
	private String label;
	private String description;
	private Calendar fulfillmentDate;
	private BigDecimal cost;

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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getFulfillmentDate() {
		return fulfillmentDate;
	}

	public void setFulfillmentDate(Calendar fulfillmentDate) {
		this.fulfillmentDate = fulfillmentDate;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}
