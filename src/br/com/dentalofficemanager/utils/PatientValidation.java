package br.com.dentalofficemanager.utils;

public class PatientValidation {

	private static int CPF_BEGIN_MARK = 0;
	private static int CPF_END_MARK_FIRST = 9;
	private static int CPF_END_MARK_SECOND = 10;
	private static int FIRST_DIGIT_MARK = 10;
	private static int SECOND_DIGIT_MARK = 11;
	private static String CPF_FORMAT_LPAD = "%011d";
	private static String CPF_PATTERN = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
	private static String CPF_PATTERN_DIGIT_ONLY = "(\\.|-)";
	
	public static boolean patientSsnValidator(String ssn) {
		boolean valid = false;

		if (ssn != null) {
			if (ssn.matches(CPF_PATTERN)) {
				String cpf = ssn.replaceAll(CPF_PATTERN_DIGIT_ONLY, "");
				if (cpf.length() < 11) {
					String.format(CPF_FORMAT_LPAD, ssn);
				}
				int firstDigit = digitCalculator(
						cpf.substring(CPF_BEGIN_MARK, CPF_END_MARK_FIRST), FIRST_DIGIT_MARK);
				int secondDigit = digitCalculator(
						cpf.substring(CPF_BEGIN_MARK, CPF_END_MARK_FIRST)
								.concat(Integer.toString(firstDigit))
								.substring(CPF_BEGIN_MARK, CPF_END_MARK_SECOND),
								SECOND_DIGIT_MARK);
				int digit = firstDigit*10 + secondDigit;
				if(Integer.parseInt(cpf.substring(9)) == digit) {
					valid = true;
				}
			}
		}
		return valid;
	}

	private static Integer digitCalculator(String cpf, Integer mark) {

		Integer digit = 0;
		int mod = 11;

		for (char c : cpf.toCharArray()) {
			digit = digit + Integer.parseInt(String.valueOf(c)) * mark;
			mark--;
		}
		
		if(digit%mod > 1) {
			digit = mod - digit%mod; 
		} else {
			digit = 0;
		}
		return digit;
	}
}
