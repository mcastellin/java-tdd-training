package org.training.ex4;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class SimpleBookingSystemDoublesTest {

    private SimpleBookingSystem bookingSystem = Mockito.spy(new SimpleBookingSystem());

    @Test
    public void shouldCallOverloadedMethod() {
        MockitoAnnotations.initMocks(this);

        Booking booking = new Booking(9, 1);
        doReturn(true).when(bookingSystem).book(booking); //try understand why we're using doReturn() with spies instead of when()

        bookingSystem.book(9, 1);

        verify(bookingSystem).book(booking);

    }
}