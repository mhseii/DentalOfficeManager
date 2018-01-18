package br.com.dentalofficemanager.patient.utils;

import br.com.dentalofficemanager.patient.model.SocialSecurityTypeEnum;

public class PatientValidationUtil {

	private static int FIRST_DIGIT_MARK = 10;
	private static int SECOND_DIGIT_MARK = 11;
	private static int MOD_OP = 11; 
	private static String CPF_PATTERN = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
	private static String CNPJ_PATTERN = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/[0-9]{4}-[0-9]{2}";
	private static String RG_PATTERN = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{1}";
	private static String DIGIT_ONLY = "[^0-9]";
	
	public static boolean ssnValidator(String ssn, SocialSecurityTypeEnum ssnType) {
		boolean isValid = false;
		switch(ssnType) {
			case CPF: isValid = cpfValidator(ssn);
				break;
			case CNPJ: isValid = cnpjValidator(ssn);
				break;
			case RG: isValid = rgValidator(ssn);
				break;
		}
		
		return isValid; 
	}
	
	private static boolean rgValidator(String ssn) {
		boolean isValid = false;
		if(ssn != null) {
			if(ssn.matches(RG_PATTERN)) {
				String rg = ssn.replaceAll(DIGIT_ONLY, "");
				if(rg.length() == 9) {
					int digit = rgDigitCalculator(rg.substring(0, rg.length()-1));
					if(rg.substring(rg.length()-1, rg.length()).equalsIgnoreCase("x") && digit == 10 
							|| (Integer.parseInt(rg.substring(rg.length()-1, rg.length())) == digit)) {
						isValid = true;
					}
				}
			}
		}
		return isValid;
	}
	
	private static int rgDigitCalculator(String rg) {
		Integer digit = 0;
		int mult = 2;
		for(int i=0; i < rg.length(); i++) {
			digit += Integer.parseInt(String.valueOf(rg.charAt(i))) * mult;
			mult++;
		}
		
		digit = MOD_OP - (digit%MOD_OP);
		return digit;
	}
	
	
	private static boolean cnpjValidator(String ssn) {
		boolean isValid = false;
		if(ssn != null) {
			if(ssn.matches(CNPJ_PATTERN)) {
				String cnpj = ssn.replaceAll(DIGIT_ONLY, "");
				if(cnpj.length() == 14) {
					int firstDigit = cnpjDigitCalculator(cnpj.substring(0, cnpj.length()-2));
					int secondDigit = cnpjDigitCalculator(cnpj.substring(0, cnpj.length()-2).concat(String.valueOf(firstDigit)));
					int digit = firstDigit*10 + secondDigit;
					if(Integer.parseInt(cnpj.substring(cnpj.length()-2)) == digit) {
						isValid = true;
					}
				}
			}
		}
		return isValid;
	}
	
	private static Integer cnpjDigitCalculator(String cnpj) {
		Integer digit = 0;
		int mult = 2;
		for(int i = 0; i < cnpj.length(); i++) {
			if(mult > 9) {
				mult = 2;
			}
			digit += Integer.parseInt(cnpj.substring(cnpj.length()-(i+1),cnpj.length() - i)) * mult;
			mult++;
		}
		if(digit%MOD_OP > 2) {
			digit = MOD_OP - (digit%MOD_OP); 
		} else {
			digit = 0;
		}
		return digit;
	}

	private static boolean cpfValidator(String ssn) {
		boolean isValid = false;
		if (ssn != null) {
			if (ssn.matches(CPF_PATTERN)) {
				String cpf = ssn.replaceAll(DIGIT_ONLY, "");
				if (cpf.length() == 11) {
					int firstDigit = cpfDigitCalculator(cpf.substring(0,cpf.length()-2), FIRST_DIGIT_MARK);
					int secondDigit = cpfDigitCalculator(cpf.substring(0,cpf.length()-2).concat(Integer.toString(firstDigit)).substring(0,cpf.length()-1), SECOND_DIGIT_MARK);
					int digit = firstDigit*10 + secondDigit;
					if(Integer.parseInt(cpf.substring(cpf.length()-2)) == digit) {
						isValid = true;
					}
				}
			}
		}
		return isValid;
	}

	private static Integer cpfDigitCalculator(String cpf, Integer mark) {
		Integer digit = 0;
		for (char c : cpf.toCharArray()) {
			digit += Integer.parseInt(String.valueOf(c)) * mark;
			mark--;
		}
		if(digit%MOD_OP > 1) {
			digit = MOD_OP - (digit%MOD_OP); 
		} else {
			digit = 0;
		}
		return digit;
	}
}
