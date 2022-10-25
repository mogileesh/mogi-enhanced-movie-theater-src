package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {
	private static final int SPECIAL = 1;
	private static final int REGULAR = 0;

	private static final int FIRST_SHOW_OF_THE_DAY = 1;
	private static final int SECOND_SHOW_OF_THE_DAY = 2;
	private static final int THIRD_SHOW_OF_THE_DAY = 3;
	private static final int FORTH_SHOW_OF_THE_DAY = 4;
	private static final int SEVENTH_DAY = 7;
	
	LocalDateTime moringTime = LocalDateTime.of(LocalDateProvider.singleton().currentDate(), LocalTime.of(9, 30));
	LocalDateTime noonTime = LocalDateTime.of(LocalDateProvider.singleton().currentDate(), LocalTime.of(12, 00));
	LocalDateTime eveningTime = LocalDateTime.of(LocalDateProvider.singleton().currentDate(), LocalTime.of(18, 00));
	
	LocalDateTime seventhDayOfTheMonthDate  = LocalDateTime.of(2022, 11, SEVENTH_DAY, 18, 00);
	
	Customer customer = new Customer("John Doe", "unused-id");
	
	 private Movie createSpecialMovie1() {
	    return MovieFactory.createMovie("Spider-Man: No Way Home", Duration.ofMinutes(90), 10, SPECIAL);
	 }
	    
	 private Movie createSpecialMovie2() {
	    return MovieFactory.createMovie("Spider-Man: Way Home", Duration.ofMinutes(90), 9, SPECIAL);
	 }
	 
	 private Movie createRegularMovie1() {
		    return MovieFactory.createMovie("The Batman", Duration.ofMinutes(90), 10, REGULAR);
		 }
	
    // Special movie reservation discount tests followed by Regular movie reservation discount tests
	 
	 @Test
    void totalFee_specialMovie_1stShowOfTheDay() {
        var showing = new Showing(
        		createSpecialMovie1(),
                FIRST_SHOW_OF_THE_DAY,
                moringTime
        );
        //System.out.println("Fee: " + new Reservation(customer, showing, 4).totalFee());
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 28.0);
    }
    
    @Test
    void totalFee_specialMovie_2ndShowOfTheDay() {
        var showing = new Showing(
        		createSpecialMovie2(),
                SECOND_SHOW_OF_THE_DAY,
                moringTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 28.0);
    }
    
    @Test
    void totalFee_specialMovie_3rdShowOfTheDay() {
        var showing = new Showing(
        		createSpecialMovie2(),
                THIRD_SHOW_OF_THE_DAY,
                moringTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 28.8);
    }
    
    @Test
    void totalFee_specialMovie_noonTimeOfTheDay() {
        var showing = new Showing(
        		createSpecialMovie2(),
                THIRD_SHOW_OF_THE_DAY,
                noonTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 27.0);
    }
    
    @Test
    void totalFee_specialMovie_eveningTimeOfTheDay() {
        var showing = new Showing(
        		createSpecialMovie1(),
        		FORTH_SHOW_OF_THE_DAY,
        		eveningTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 32.0);
    }
    
    @Test
    void totalFee_specialMovie_seventhDayOfTheMonth() {
        var showing = new Showing(
        		createSpecialMovie1(),
        		FORTH_SHOW_OF_THE_DAY,
        		seventhDayOfTheMonthDate
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 32.0);
    }
    
    
    // Regular movie reservation discount tests
    
    @Test
    void totalFee_regularMovie_1stShowOfTheDay() {
        var showing = new Showing(
        		createRegularMovie1(),
                FIRST_SHOW_OF_THE_DAY,
                moringTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 28.0);
    }
    
    @Test
    void totalFee_regularMovie_2ndShowOfTheDay() {
        var showing = new Showing(
        		createRegularMovie1(),
                SECOND_SHOW_OF_THE_DAY,
                moringTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 32.0);
    }
    
    @Test
    void totalFee_regularMovie_3rdShowOfTheDay__noDiscount() {
        var showing = new Showing(
        		createRegularMovie1(),
                THIRD_SHOW_OF_THE_DAY,
                moringTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 40.0);
    }
    
    @Test
    void totalFee_regularMovie_noonTimeOfTheDay() {
        var showing = new Showing(
        		createRegularMovie1(),
                THIRD_SHOW_OF_THE_DAY,
                noonTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 30.0);
    }
    
    @Test
    void totalFee_regularMovie_seventhDayOfTheMonth() {
        var showing = new Showing(
        		createRegularMovie1(),
        		FORTH_SHOW_OF_THE_DAY,
        		seventhDayOfTheMonthDate
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 36.0);
    }
    
    @Test
    void totalFee_regularMovie_eveningTimeOfTheDay_noDiscount() {
        var showing = new Showing(
        		createRegularMovie1(),
        		FORTH_SHOW_OF_THE_DAY,
        		eveningTime
        );
        assertTrue(new Reservation(customer, showing, 4).totalFee() == 40.0);
    }
    
}
