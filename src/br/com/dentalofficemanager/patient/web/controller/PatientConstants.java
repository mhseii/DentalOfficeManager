package br.com.dentalofficemanager.patient.web.controller;

public interface PatientConstants {

	// CONTORLLER URL CONSTANTS
	public static final String URL_REGISTER_PATIENT = "/patient/register";
	public static final String URL_SEARCH_PATIENT = "/patient/search";
	public static final String URL_VIEW_PATIENT = "/patient/view";
	public static final String URL_LIST_PATIENT = "/patient/list";
	
	// JSP URLs
	public static final String JSP_REGISTER_PATIENT = "/patient/register_patient";
	public static final String JSP_REGISTER_ANAMNESIS = "/patient/register_patient_anamnesis";
	public static final String JSP_VIEW_PATIENT = "/patient/view_patient";
	public static final String JSP_LIST_PATIENTS = "/patient/list_patients";
	
	// FORM CONSTANTS
	public static final String PATIENT_REGISTRATION_FORM = "/patient/registration_form";
	
	// others
	public static final String REDIRECT_URL_ANAMNESIS = "anamnesis";
	public static final String REDIRECT_URL_LIST_PATIENT = "list";

}
