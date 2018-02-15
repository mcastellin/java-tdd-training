package org.training.ex6.impl;

import org.training.ex6.RaceResultsService;
import org.training.ex6.dto.Message;
import org.training.ex6.dto.SubscriptionClient;

import java.util.HashSet;
import java.util.Set;

public class DefaultRaceResultsService implements RaceResultsService {

    private Set<SubscriptionClient> subscribers;

    public DefaultRaceResultsService() {
        subscribers = new HashSet<SubscriptionClient>();
    }

    public void addSubscriber(SubscriptionClient client) {
        subscribers.add(client);
    }

    public void removeSubscriber(SubscriptionClient client) {
        subscribers.remove(client);
    }

    public void send(Message message) {
        for (SubscriptionClient client : subscribers) {
            client.receive(message);
        }
    }

}
