package org.training.examples;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TestDoublesExamplesTest {

    @Test
    public void shouldAddSerializableObject() {
        Serializable obj = Mockito.mock(Serializable.class); // creating dummy from interface
        ArrayList<Serializable> list = new ArrayList<Serializable>(); // SUT

        list.add(obj);

        assertThat(list).contains(obj);
    }

    @Test
    public void shouldBeActiveWhenCollaboratorIsActive() {
        Collaborator collaborator = Mockito.mock(Collaborator.class);
        Mockito.when(collaborator.isActive()).thenReturn(true); // defining indirect input for collaborator

        SimpleService simpleService = new SimpleService(); // creating SUT with stub collaborator
        simpleService.setCollaborator(collaborator);

        boolean isServiceActive = simpleService.isServiceActive();

        assertTrue("Service should be active.", isServiceActive);
    }

    @Test
    public void shouldMakeCallToCollaborator() {
        SimpleService simpleService = new SimpleService(); // SUT

        // create collaborator as a mock
        Collaborator collaborator = Mockito.mock(Collaborator.class);
        Mockito.when(collaborator.isActive()).thenReturn(true);
        simpleService.setCollaborator(collaborator);

        Serializable payload = Mockito.mock(Serializable.class);
        simpleService.makeCall(payload);

        Mockito.verify(collaborator).executeAction(payload); // verify collaborator
    }

    @Test
    public void shouldPerformOperationWhenServiceActive() {
        SimpleService simpleService = Mockito.spy(new SimpleService()); // creating SUT as a spy
        Mockito.doReturn(true).when(simpleService).isServiceActive(); // overriding real isActive()
        Mockito.doNothing().when(simpleService).performOperation(null);

        simpleService.makeCall(null); // real makeCall()

        Mockito.verify(simpleService).performOperation(null);
    }

    @Test(expected = ClassCastException.class)
    public void mockitoMatchersExample() {
        List<String> list = Mockito.mock(List.class);
        Mockito.doThrow(ClassCastException.class).when(list).contains(Matchers.anyDouble());

        list.contains(Double.valueOf(1));
    }
}

interface Collaborator {
    boolean isActive();

    void executeAction(Serializable payload);
}

class SimpleService {
    private Collaborator collaborator;

    void setCollaborator(Collaborator c) {
        this.collaborator = c;
    }

    public boolean isServiceActive() {
        return collaborator.isActive();
    }

    public void makeCall(Serializable payload) {
        if (isServiceActive()) {
            performOperation(payload);
        }
    }

    public void performOperation(Serializable payload) {
        collaborator.executeAction(payload);
    }
}
