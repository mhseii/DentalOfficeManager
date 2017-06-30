package br.com.dentalofficemanager.patient.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.dentalofficemanager.constants.SystemConstants;

public class DateFormatUtil implements SystemConstants{

	public static Calendar formatDate(String dateString, String dateFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar date = Calendar.getInstance();
		date.setTime(sdf.parse(dateString));
		return date;
	}

}
