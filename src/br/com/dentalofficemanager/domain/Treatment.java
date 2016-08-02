package br.com.dentalofficemanager.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class Treatment {

	/*
	 * This class represents treatment ratings
	 * There should be variables like
	 * 
	 * Id
	 * Patient info (patient id, fullname, cpf, etc)
	 * Payment info (ammount, whether there's a pre-payment, etc)
	 * Dates (treatment start and end dates)  
	 * List of appointments during this 
	 * 
	 * **/
	
	private Long id;
	private Long patientId;
	private Patient patient;
	private BigDecimal totalCost;
	private BigDecimal prePayment;
	private Boolean hasPrePayment;
	private Calendar startDate;
	private Calendar endDate;
	private Boolean isFinished;
	private List<Appointment> appointments;
	
}
