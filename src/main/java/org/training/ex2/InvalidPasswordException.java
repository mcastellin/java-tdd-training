package org.training.ex2;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException() {
        super();
    }

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException(String message, Exception cause) {
        super(message, cause);
    }
}
