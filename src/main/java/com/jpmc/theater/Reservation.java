package com.jpmc.theater;

import com.jpmc.theater.discount.DiscountCalculateServiceFactory;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    public double totalFee() {
        return (showing.getTicketPrice() - getDiscount()) * audienceCount;
    }
    
    private double getDiscount() {
    	return DiscountCalculateServiceFactory.getDiscountCalculateService().calculateDiscount(showing);
    }
}