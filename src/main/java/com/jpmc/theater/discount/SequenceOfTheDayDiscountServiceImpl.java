package com.jpmc.theater.discount;

import com.jpmc.theater.Showing;

public class SequenceOfTheDayDiscountServiceImpl implements DiscountCalculateService {
	private static final int FIRST_SHOW_OF_THE_DAY = 1;
	private static final int SECOND_SHOW_OF_THE_DAY = 2;
	private static final double FIRST_SHOW_OF_THE_DAY_DISCOUNT = 3;
	private static final double SECOND_SHOW_OF_THE_DAY_DISCOUNT = 2;
	
	@Override
	public double calculateDiscount(Showing showing) {
		int sequenceOfTheDay = showing.getSequenceOfTheDay();
		double discount = 0;
		switch(sequenceOfTheDay) {
			case FIRST_SHOW_OF_THE_DAY :
				discount = FIRST_SHOW_OF_THE_DAY_DISCOUNT;
				break;
			case SECOND_SHOW_OF_THE_DAY :
				discount = SECOND_SHOW_OF_THE_DAY_DISCOUNT;
				break;
		}
		return discount;
	}
}
