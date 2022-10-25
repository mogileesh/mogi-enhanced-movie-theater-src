package com.jpmc.theater.print;

import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.jpmc.theater.Showing;

public class SchedulePrinterJSON implements SchedulePrinter {

	@Override
	public void printSchedule(LocalDate currentDate, List<Showing> schedule) {
		System.out.println(currentDate);
	    System.out.println("===================================================");
	    schedule.forEach(s ->
	    	  	System.out.println(new Gson().toJson(s)) 
	    );
	    System.out.println("===================================================");  
	}

}
