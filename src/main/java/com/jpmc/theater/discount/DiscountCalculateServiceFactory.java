package com.jpmc.theater.discount;

public class DiscountCalculateServiceFactory {
	public static DiscountCalculateService getDiscountCalculateService() {
		return new DiscountCalculateServiceImpl();
	}
}
