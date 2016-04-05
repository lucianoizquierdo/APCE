package com.apce.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		DateFormat datos = new SimpleDateFormat("HH:mm:ss");
//		
//		Calendar cal1 = Calendar.getInstance();
		int minutos = 120; 
//		int millis = minutos * 60;
//		cal1.setTimeInMillis(1);
		
		int hours = minutos / 60; //since both are ints, you get an int
		int minutes = minutos % 60;
		System.out.printf("%d:%02d", hours, minutes);
		
//		cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
//		cal1.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
//		cal1.set(Calendar.SECOND, Integer.parseInt(parts[2]));
		
	}

}
