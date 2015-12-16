package edu.mum.tmsystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date getCombinedDateTime(Date date, String time) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String dateValue = sdf2.format(date);
		dateValue = dateValue + " " + time;
		return sdf1.parse(dateValue);
	}
	
	public static Date getCurrentDate(){
		return new Date();
	}

}
