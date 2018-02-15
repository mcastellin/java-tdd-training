package org.training.ex5;

import org.training.ex5.dto.Client;
import org.training.ex5.dto.Template;

public interface Messenger {

    void sendMessage(Client client, Template template);
}
