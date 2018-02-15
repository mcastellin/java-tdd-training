package org.training.ex5.impl;

import org.training.ex5.MailServer;
import org.training.ex5.Messenger;
import org.training.ex5.TemplateEngine;
import org.training.ex5.dto.Client;
import org.training.ex5.dto.Template;

public class DefaultMessenger implements Messenger {

    private MailServer mailServer;
    private TemplateEngine templateEngine;

    public DefaultMessenger(MailServer mailServer, TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    public void sendMessage(Client client, Template template) {
        String message = templateEngine.prepareMessage(template, client);
        final String clientEmailAddr = client.getEmailAddr();
        mailServer.send(clientEmailAddr, message);
    }
}
