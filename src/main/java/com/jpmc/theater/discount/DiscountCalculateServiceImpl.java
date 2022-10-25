package com.jpmc.theater.discount;

import java.util.ArrayList;
import java.util.List;
import com.jpmc.theater.Showing;

public class DiscountCalculateServiceImpl implements DiscountCalculateService {
	private static List<DiscountCalculateService> discountList = new ArrayList<>();
	static {
		discountList.add(new SpecialMovieDiscountServiceImpl());
		discountList.add(new SequenceOfTheDayDiscountServiceImpl());
		discountList.add(new TimeOfTheDayDiscountServiceImpl());
		discountList.add(new DayOfTheMonthDiscountServiceImpl());
	}
	
	public double calculateDiscount(Showing showing) {
		double maxDiscount = 0;
		for (DiscountCalculateService discountService : DiscountCalculateServiceImpl.discountList) {
			maxDiscount = Math.max(maxDiscount, discountService.calculateDiscount(showing));
		}
		return maxDiscount;
	}
	
	
}


