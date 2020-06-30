package com.erme.taxeTnb.service.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	@SuppressWarnings("deprecation")
	public static long diff(Date datePresentation, int annee) {
		LocalDate localDate = LocalDate.of(annee, 4, 1);
		LocalDate datePresentationAsLocalDate = convertToLocalDateViaInstant(datePresentation);		
		long diffMonths = Period.between(localDate, datePresentationAsLocalDate).getMonths();
		long diffYear = Period.between(localDate, datePresentationAsLocalDate).getYears();
		long diff = (diffYear*12)+diffMonths;
		if (diff<0) {
			diff = 0;
		}
		return diff;
	}

	private static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {

	    return dateToConvert.toInstant()

	      .atZone(ZoneId.systemDefault())

	      .toLocalDate();

	}
	
}
