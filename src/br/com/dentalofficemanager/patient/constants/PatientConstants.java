package br.com.dentalofficemanager.patient.constants;

public interface PatientConstants {

	// CONTORLLER URL CONSTANTS
	public static final String PATIENT_CONTEXT_PATH = "/patient/*";
	public static final String URL_REGISTER_PATIENT = "/register";
	public static final String URL_SEARCH_PATIENT = "/search";
	public static final String URL_VIEW_PATIENT = "/view";
	public static final String URL_LIST_PATIENT = "/list";
	public static final String URL_REGISTER_ANAMNESIS = "/anamnesis";
	
	// JSP URLs
	public static final String JSP_REGISTER_PATIENT = "/patient/register_patient";
	public static final String JSP_REGISTER_ANAMNESIS = "/patient/register_anamnesis";
	public static final String JSP_VIEW_PATIENT = "/patient/view_patient";
	public static final String JSP_LIST_PATIENTS = "/patient/list_patients";
	
	// FORM CONSTANTS
	public static final String PATIENT_REGISTRATION_FORM = "registration_form";
	
	// others
	public static final String REDIRECT_URL_LIST_PATIENT = "list";
	public static final String REDIRECT_URL_VIEW_PATIENT = "view";
	public static final String REDIRECT_URL_ANAMNESIS = "anamnesis";

}
