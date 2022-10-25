package com.jpmc.theater;

import java.time.Duration;

public class MovieFactory {
	public static Movie  createMovie(String title, Duration runningTime, double ticketPrice, int specialCode) {
		if(specialCode > 0)
			return new SpecialMovie(title, runningTime, ticketPrice, specialCode);
		else
			return new Movie(title, runningTime, ticketPrice);
	}
}
