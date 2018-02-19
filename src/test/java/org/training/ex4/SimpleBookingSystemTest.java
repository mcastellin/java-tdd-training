package org.training.ex4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

@RunWith(JUnitParamsRunner.class)
public class SimpleBookingSystemTest {

    SimpleBookingSystem bookingSystem;

    @Before
    public void setUp() {
        bookingSystem = new SimpleBookingSystem();
    }

    private static Collection invalidTestData() {
        return Arrays.asList(new Object[][]{
                {-1, 1},
                {10, -1},
                {10, 0},
                {-1, -1}
        });
    }

    /**
     * Booking times allowed are from 9AM to 6PM
     */
    private static Collection failingBookingRequests() {
        return Arrays.asList(new Object[][]{
                {1, 1},
                {9, 10},
                {8, 1},
                {8, 9},
                {18, 1},
                {17, 2}
        });
    }

    @Test
    public void shouldReturnBookedHours() {
        Booking booking1 = new Booking(9, 2),
                booking2 = new Booking(16, 1);
        bookingSystem.book(booking1);
        bookingSystem.book(booking2);

        Collection<Booking> bookings = bookingSystem.getBookings();

        assertThat(bookings).containsOnly(
                booking1,
                booking2
        );
    }

    @Test
    public void shouldNotDoubleBook() {
        int fromHour = 9, duration = 2;
        bookingSystem.book(fromHour, duration);

        boolean doubleBookingResult = bookingSystem.book(fromHour, duration);

        assertFalse("Should not double-book", doubleBookingResult);
    }

    @Test
    public void shouldNotOverlapBookings() {
        int fromHour1 = 9, duration1 = 3,
                fromHour2 = 10, duration2 = 1;
        bookingSystem.book(fromHour1, duration1);

        boolean overlapBookingResult = bookingSystem.book(fromHour2, duration2);

        assertFalse("Should not be able to overlap bookings", overlapBookingResult);
    }

    @Parameters(method = "invalidTestData")
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWithInvalidParams(int fromTime, int duration) {

        bookingSystem.book(fromTime, duration);
    }

    @Parameters(method = "failingBookingRequests")
    @Test
    public void shouldFailToBook(int fromTime, int duration) {

        boolean bookingResult = bookingSystem.book(fromTime, duration);

        assertFalse("Booking request from this dataset should fail", bookingResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWitNullParameter() {

        bookingSystem.book(null);
    }
}