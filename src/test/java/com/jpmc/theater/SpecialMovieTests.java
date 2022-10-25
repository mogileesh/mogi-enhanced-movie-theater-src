package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

class SpecialMovieTests {
	private static final int SPECIAL = 1;
	
	 @Test
	    void specialMovieTest() {
	        Movie spiderMan = MovieFactory.createMovie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL);
	        assertTrue(spiderMan instanceof SpecialMovie);
	        assertTrue(spiderMan instanceof Movie);
	    }
	 
	 @Test
	    void specialMovie_testFields() {
		 	Movie spiderMan = MovieFactory.createMovie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL);;
	        assertEquals("Spider-Man: No Way Home", spiderMan.getTitle());
	        assertEquals(90, spiderMan.getRunningTime().toMinutes());
	        assertEquals(12.5, spiderMan.getTicketPrice());
	    }
	 
	 @Test
	    void specialMovie_testToString() {
		 Movie spiderMan = MovieFactory.createMovie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL);
		 spiderMan.toString();
	    }

}
