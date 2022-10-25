package com.jpmc.theater;

import java.time.Duration;
import java.util.Objects;

public class SpecialMovie extends Movie {
	private int specialCode;
	
	public SpecialMovie(String title, Duration runningTime, double ticketPrice, int specialCode) {
		super(title, runningTime, ticketPrice);
		this.specialCode = specialCode;
	}
	 
	public int getSpecialCode() {
		return specialCode;
	}

	public void setSpecialCode(int specialCode) {
		this.specialCode = specialCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
	    if (!(o instanceof SpecialMovie)) return false;
	    SpecialMovie movie = (SpecialMovie) o;
	    return Double.compare(movie.ticketPrice, ticketPrice) == 0
	    		&& Objects.equals(title, movie.title)
	            && Objects.equals(description, movie.description)
	            && Objects.equals(runningTime, movie.runningTime)
	            && Objects.equals(specialCode, movie.specialCode);
	}
	
	 @Override
	 public int hashCode() {
		 return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
	 }

	 @Override
	 public String toString() {
		 return super.toString();
	 }
}
