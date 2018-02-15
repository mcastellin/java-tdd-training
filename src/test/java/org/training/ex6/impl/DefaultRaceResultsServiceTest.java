package org.training.ex6.impl;

import org.junit.Before;
import org.junit.Test;
import org.training.ex6.RaceResultsService;
import org.training.ex6.dto.Message;
import org.training.ex6.dto.SubscriptionClient;

import static org.mockito.Mockito.*;

public class DefaultRaceResultsServiceTest {

    private RaceResultsService raceResultsService;
    private Message message;

    @Before
    public void setUp() {
        message = mock(Message.class);
        raceResultsService = new DefaultRaceResultsService();
    }


    @Test
    public void subscribedClientShouldReceiveMessage() {

        SubscriptionClient subscriber = mock(SubscriptionClient.class);
        raceResultsService.addSubscriber(subscriber);

        raceResultsService.send(message);

        verify(subscriber).receive(message);
    }

    @Test
    public void allSubscribersShouldReceiveMessage() {

        SubscriptionClient subscriber1 = mock(SubscriptionClient.class);
        SubscriptionClient subscriber2 = mock(SubscriptionClient.class);

        raceResultsService.addSubscriber(subscriber1);
        raceResultsService.addSubscriber(subscriber2);

        raceResultsService.send(message);

        verify(subscriber1).receive(message);
        verify(subscriber2).receive(message);
    }

    @Test
    public void notSubscribedClientsShouldNotReceiveMessage() {

        SubscriptionClient subscriber1 = mock(SubscriptionClient.class);

        raceResultsService.send(message);

        verify(subscriber1, never()).receive(message);
    }

    @Test
    public void clientSubscribedMoreThanOnceShouldReceiveOneMessage() {

        SubscriptionClient subscriber1 = mock(SubscriptionClient.class);
        raceResultsService.addSubscriber(subscriber1);
        raceResultsService.addSubscriber(subscriber1);

        raceResultsService.send(message);

        verify(subscriber1).receive(message);
    }

    @Test
    public void unsubscribedClientsShouldNotReceiveMessage() {

        SubscriptionClient subscriber1 = mock(SubscriptionClient.class);
        raceResultsService.addSubscriber(subscriber1);
        raceResultsService.removeSubscriber(subscriber1);

        raceResultsService.send(message);

        verify(subscriber1, never()).receive(message);
    }
}