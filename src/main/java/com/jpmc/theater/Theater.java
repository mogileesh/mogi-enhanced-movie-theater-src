package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.jpmc.theater.print.PrintType;
import com.jpmc.theater.print.SchedulePrinterFactory;

public class Theater {

    LocalDateProvider provider;
    private List<Showing> schedule;
    private static final int SPECIAL = 1;
    private static final int REGULAR = 0;

    public Theater(LocalDateProvider provider) {
        this.provider = provider;

        Movie spiderMan = MovieFactory.createMovie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL);
        Movie turningRed = MovieFactory.createMovie("Turning Red", Duration.ofMinutes(85), 11, REGULAR);
        Movie theBatMan = MovieFactory.createMovie("The Batman", Duration.ofMinutes(95), 9, REGULAR);
        
        schedule = List.of(
            new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
        );
    }

    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Showing showing;
        try {
            showing = schedule.get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        return new Reservation(customer, showing, howManyTickets);
    }

    public void printSchedule(PrintType printType) {
    	SchedulePrinterFactory.getSchedulePrinter(printType).printSchedule(provider.currentDate(), schedule);
    }

    public static void main(String[] args) {
        Theater theater = new Theater(LocalDateProvider.singleton());
        theater.printSchedule(PrintType.TEXT);
    }
}
