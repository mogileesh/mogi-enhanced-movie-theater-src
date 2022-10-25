package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import com.jpmc.theater.print.PrintType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheaterTests {
	
	Theater theater = new Theater(LocalDateProvider.singleton());
    
    @Test
    void totalFeeForCustomer_specialMovieDiscount() {
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 2, 4);
        assertEquals(reservation.totalFee(),37.5);
    }
    
    @Test
    void totalFeeForCustomer_regularMovie_1stShowoftheDayDiscount() {
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 1, 10);
        assertEquals(reservation.totalFee(),80.00);
    }
    
    @Test
    void totalFeeForCustomer_regularMovie_showTimeDiscount() {
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 3, 10);
        assertEquals(reservation.totalFee(),67.50);
    }

    @Test
    void printMovieScheduleText() {
        theater.printSchedule(PrintType.TEXT);
    }
    
    @Test
    void printMovieScheduleJson() {
        theater.printSchedule(PrintType.JSON);
    }
}
