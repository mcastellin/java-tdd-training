package org.training.ex2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

    public static Collection goodPasswords() {
        return Arrays.asList(
                "p@ss123",
                "@sdfggh1",
                "?iwantmom99?"

        );
    }

    public static Collection badPasswords() {
        return Arrays.asList(
                "p123",
                "asdfgghasdf",
                "p@ss",
                "rand0m",
                "123456789",
                "my*pass123_"
        );
    }


    @Parameters(method = "goodPasswords")
    @Test
    public void validateGoodPassword(String goodPassword) {

        String exceptionString = null;

        try {
            PasswordValidator.validate(goodPassword);
        } catch (InvalidPasswordException e) {
            exceptionString = e.getClass().getName();
        }

        assertNull(String.format("Exception %s was not expected.", exceptionString),
                exceptionString);

    }

    @Parameters(method = "badPasswords")
    @Test(expected = InvalidPasswordException.class)
    public void validateBadPasswords(String badPassword) throws InvalidPasswordException {

        PasswordValidator.validate(badPassword);

    }

    @Test(expected = IllegalArgumentException.class)
    public void validateNullPasswordShoulThrowIllegalArgument() throws InvalidPasswordException {

        PasswordValidator.validate(null);

    }

    @Parameters(method = "badPasswords")
    @Test
    public void checkExceptionHasMessage(String badPass) {
        boolean exceptionThrown = false;
        try {
            PasswordValidator.validate(badPass);
        } catch (InvalidPasswordException e) {
            assertThat(e.getMessage()).isNotEmpty();
            exceptionThrown = true;
        }

        assertTrue("Exception not thrown", exceptionThrown);
    }
}