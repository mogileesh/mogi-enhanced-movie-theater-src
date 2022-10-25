package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;

public class DayOfTheMonthDiscountServiceImpl implements DiscountCalculateService {
	private static final int DAY_OF_THE_MONTH_DISCOUNT_DAY = 7;
	private static final double DAY_OF_THE_MONTH_DISCOUNT = 1;
	
	@Override
	public double calculateDiscount(Showing showing) {
		int day = showing.getStartTime().getDayOfMonth();
		return day == DAY_OF_THE_MONTH_DISCOUNT_DAY ? DAY_OF_THE_MONTH_DISCOUNT : 0;
	}

}
