package org.training.ex5.impl;

import org.junit.Before;
import org.junit.Test;
import org.training.ex5.MailServer;
import org.training.ex5.TemplateEngine;
import org.training.ex5.dto.Client;
import org.training.ex5.dto.Template;

import static org.mockito.Mockito.*;

public class DefaultMessengerTest {

    private DefaultMessenger messenger;
    private MailServer mailServer;
    private TemplateEngine templateEngine;

    private Template msgTemplate;
    private Client msgClient;

    private static final String MSG_CONTENT = "This is a very important message!";
    private static final String CLIENT_EMAIL = "someemail@thecompany.com";

    @Before
    public void setUp() {
        msgTemplate = mock(Template.class);
        msgClient = mock(Client.class);

        mailServer = mock(MailServer.class); //plain mock object
        templateEngine = mock(TemplateEngine.class); //stub creation for templateEngine
        when(templateEngine.prepareMessage(msgTemplate, msgClient)).thenReturn(MSG_CONTENT);

        messenger = new DefaultMessenger(mailServer, templateEngine);
    }

    @Test
    public void shouldSendEmail() {

        when(msgClient.getEmailAddr()).thenReturn(CLIENT_EMAIL);

        messenger.sendMessage(msgClient, msgTemplate);

        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}