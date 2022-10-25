package com.jpmc.theater;

import java.time.Duration;
import java.util.Objects;

public class Movie {

    protected String title;
    protected String description;
    protected Duration runningTime;
    protected double ticketPrice;

    public Movie(String title, Duration runningTime, double ticketPrice) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice);
    }
    
    @Override
    public String toString() {
    	return new StringBuilder(title).append(" ").append(FormatUtils.humanReadableFormat(runningTime)).append(" $").append(ticketPrice).toString();
    }
   
}