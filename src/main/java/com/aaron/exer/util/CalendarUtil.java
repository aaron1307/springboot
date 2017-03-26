package com.aaron.exer.util;

import java.util.Calendar;

/**
 * CalendarUtil created to generate calendar related info
 * 
 * @author Aaron C.
 * @version v0.1
 */
public class CalendarUtil {

	/**   
	 * @Title: getCurrentDate   
	 * @Description: get current timpstamp
	 * @param: String
	 * @return: null
	 * @throws   
	 */  
	public static String getCurrentDate() {

		Calendar now = Calendar.getInstance();

		// Date d = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String dateNowStr = sdf.format(d);

		return now.getTime().toString();
	}
}
