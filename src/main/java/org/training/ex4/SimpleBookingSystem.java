package org.training.ex4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Resource can be booked only from 9AM to 6PM => only 9 available time slots
 */
public class SimpleBookingSystem {

    List<Booking> bookings;

    public SimpleBookingSystem() {
        this.bookings = new ArrayList<Booking>();
    }

    public boolean book(Booking newBooking) {
        validateBookingParameters(newBooking);

        if (isAllowedToBook(newBooking)) {
            bookings.add(newBooking);
            return true;
        }

        return false;
    }

    public boolean book(int fromTime, int duration) {
        return book(new Booking(fromTime, duration));
    }

    protected boolean isAllowedToBook(Booking booking) {
        boolean[] bookableTimes = getBookableTimes();

        boolean canBook = true;
        try {
            for (int i = booking.getStartTime() - 9; i < booking.getEndTime() - 9 && canBook; i++) {
                canBook &= bookableTimes[i];
            }
        } catch (ArrayIndexOutOfBoundsException notAllowedTimeBookException) {
            canBook = false;
        }
        return canBook;
    }

    protected boolean[] getBookableTimes() {
        boolean[] bookableTimes = new boolean[9];
        for (int i = 0; i < bookableTimes.length; i++) {
            bookableTimes[i] = true;
        }

        for (Booking booking : bookings) {
            for (int i = booking.getStartTime() - 9; i < booking.getEndTime() - 9; i++) {
                bookableTimes[i] = false;
            }
        }
        return bookableTimes;
    }

    private void validateBookingParameters(Booking newBooking) {

        if (newBooking == null) {
            throw new IllegalArgumentException("Null booking objects are not allowed");
        }
        if (newBooking.getStartTime() < 0 || newBooking.getDuration() < 0) {
            throw new IllegalArgumentException("Booking parameters cannot be negative");
        }
        if (newBooking.getDuration() == 0) {
            throw new IllegalArgumentException("Booking duration cannot be zero");
        }
    }

    public Collection<Booking> getBookings() {

        return new ArrayList<Booking>(bookings);
    }
}
