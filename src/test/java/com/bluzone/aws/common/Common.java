package com.bluzone.aws.common;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Common {

	private static HashMap<String, String> dateGeneration = new HashMap<String, String>();

	public void mailIdGeneration() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
		DateFormat dateFormatPage = new SimpleDateFormat("M/d/yyyy h:mm");
		dateGeneration.put("date", dateFormat.format(date));
		dateGeneration.put("datePage", dateFormatPage.format(date));
	}

	public static HashMap<String, String> getDateGeneration() {
		return dateGeneration;
	}

	
	
}
