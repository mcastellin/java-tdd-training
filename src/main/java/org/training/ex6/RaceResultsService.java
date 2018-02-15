package org.training.ex6;

import org.training.ex6.dto.Message;
import org.training.ex6.dto.SubscriptionClient;

public interface RaceResultsService {

    void addSubscriber(SubscriptionClient client);

    void send(Message message);

    void removeSubscriber(SubscriptionClient subscriber1);
}
