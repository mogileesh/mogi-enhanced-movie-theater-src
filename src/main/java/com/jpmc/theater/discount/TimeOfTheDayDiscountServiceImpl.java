package com.jpmc.theater.discount;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.jpmc.theater.Showing;

public class TimeOfTheDayDiscountServiceImpl implements DiscountCalculateService {
	private static final LocalTime TIME_OF_THE_DAY_DISCOUNT_START_TIME = LocalTime.of(11, 0);
	private static final LocalTime TIME_OF_THE_DAY_DISCOUNT_END_TIME = LocalTime.of(16, 0);
	private static final double TIME_OF_THE_DAY_DISCOUNT_RATE = 0.25;
	
	@Override
	public double calculateDiscount(Showing showing) {
		LocalDateTime startTime = showing.getStartTime();
		LocalTime time = LocalTime.of(startTime.getHour(), startTime.getMinute());
		return time.compareTo(TIME_OF_THE_DAY_DISCOUNT_START_TIME) >= 0 && 
				time.compareTo(TIME_OF_THE_DAY_DISCOUNT_END_TIME) <= 0 ? TIME_OF_THE_DAY_DISCOUNT_RATE * showing.getTicketPrice() : 0; 
	}

}
