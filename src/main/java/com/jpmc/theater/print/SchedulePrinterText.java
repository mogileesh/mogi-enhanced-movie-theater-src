package com.jpmc.theater.print;

import java.time.LocalDate;
import java.util.List;

import com.jpmc.theater.Showing;

public class SchedulePrinterText implements SchedulePrinter {
	
	 public void printSchedule(LocalDate currentDate, List<Showing> schedule) {
	        System.out.println(currentDate);
	        System.out.println("===================================================");
	        schedule.forEach(s ->
	                System.out.println(s.toString())
	        );
	        System.out.println("===================================================");
	    }
}
