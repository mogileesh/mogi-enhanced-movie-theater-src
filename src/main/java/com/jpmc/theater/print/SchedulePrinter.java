package com.jpmc.theater.print;

import java.time.LocalDate;
import java.util.List;

import com.jpmc.theater.Showing;

public interface SchedulePrinter {
	public void printSchedule(LocalDate currentDate, List<Showing> schedule);
}
