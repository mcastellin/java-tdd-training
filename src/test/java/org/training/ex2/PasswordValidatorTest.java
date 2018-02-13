package org.training.ex2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import sun.security.util.Password;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.fest.assertions.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

    public static Collection goodPasswords() {
        return Arrays.asList(
                "pass123",
                "asdfggh1"
        );
    }

    public static Collection badPasswords() {
        return Arrays.asList(
                "p123",
                "asdfgghasdf"
        );
    }


    @Parameters(method = "goodPasswords")
    @Test
    public void validateGoodPassword(String goodPassword) throws InvalidPasswordException {

        PasswordValidator.validate(goodPassword);

    }

    @Parameters(method = "badPasswords")
    @Test(expected = InvalidPasswordException.class)
    public void validateBadPasswords(String badPass) throws InvalidPasswordException {

        PasswordValidator.validate(badPass);

    }

    @Parameters(method = "badPasswords")
    @Test
    public void checkExceptionHasMessage(String badPass) {
        try {
            PasswordValidator.validate(badPass);
        } catch (InvalidPasswordException e) {
            assertThat(e.getMessage()).isNotEmpty();
        }finally {
            Assertions.fail("Exception not thrown");
        }

    }
}