package br.com.dentalofficemanager.patient.exceptions;

public class InvalidSocialSecurityNumberException extends Exception {

	private static final long serialVersionUID = -8794310815611231731L;

	public InvalidSocialSecurityNumberException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidSocialSecurityNumberException(String message) {
		super(message);
	}
	
	public InvalidSocialSecurityNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}
