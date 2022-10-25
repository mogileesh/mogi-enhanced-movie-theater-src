package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTests {
	private static final int REGULAR = 0;
	
    @Test
    void regularMovieTest() {
        Movie batsman = MovieFactory.createMovie("The Batman", Duration.ofMinutes(90),10, REGULAR);
        assertFalse(batsman instanceof SpecialMovie);
        assertTrue(batsman instanceof Movie);
    }
    
    @Test
    void regularMovie_testFields() {
        Movie batsman = MovieFactory.createMovie("The Batman", Duration.ofMinutes(90),10, REGULAR);
        assertEquals("The Batman", batsman.getTitle());
        assertEquals(90, batsman.getRunningTime().toMinutes());
        assertEquals(10.0, batsman.getTicketPrice());
    }
    
    @Test
    void regularMovie_testToString() {
       Movie batsman = MovieFactory.createMovie("The Batman", Duration.ofMinutes(90),10, REGULAR);
       batsman.toString();
    } 
   
}
