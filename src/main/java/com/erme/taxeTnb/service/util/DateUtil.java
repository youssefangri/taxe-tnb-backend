package com.erme.taxeTnb.service.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public static long diff(Date datePresentation, int annee) {
		LocalDate localDate = LocalDate.of(annee, 4, 1);
		LocalDate datePresentationAsLocalDate = convertToLocalDateViaInstant(datePresentation);
		long diff = Period.between(localDate, datePresentationAsLocalDate).getMonths();
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
