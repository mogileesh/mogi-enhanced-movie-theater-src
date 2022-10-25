package com.jpmc.theater.discount;

import com.jpmc.theater.Movie;
import com.jpmc.theater.Showing;
import com.jpmc.theater.SpecialMovie;

public class SpecialMovieDiscountServiceImpl implements DiscountCalculateService {
	private static final double SPECIAL_DISCOUNT_RATE = 0.2;
	@Override
	public double calculateDiscount(Showing showing) {
		Movie movie = showing.getMovie();
		return movie instanceof SpecialMovie ? movie.getTicketPrice() * SPECIAL_DISCOUNT_RATE : 0;
	}

}
