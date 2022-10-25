package com.jpmc.theater;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getTicketPrice() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }
    
    @Override
    public String toString() {
    	return new StringBuilder(sequenceOfTheDay).append(": ").append(showStartTime).append(" ").append(movie.toString()).toString();
    }
}
