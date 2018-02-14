package org.training.ex2;

public class PasswordValidator {

    public static void validate(String passwordString) throws InvalidPasswordException {

        if(passwordString == null) {
            throw new IllegalArgumentException("password cannot be null");
        }

        if (!(passwordString.length() >= 5)) {
            throw new InvalidPasswordException("String must be at least 5 character long");
        }

        if(!passwordString.matches("[a-zA-Z0-9_!?@]*")){
            throw new InvalidPasswordException("Characters allowed are a-z, a-Z, 0-9, _, !, ? or @");
        }

        if(!passwordString.matches(".*[_!?@]+.*")){
            throw new InvalidPasswordException("Password must contain at least one of the following: _, !, ? or @");
        }

        if(!passwordString.matches(".*\\d+.*")){
            throw new InvalidPasswordException("Password must contain at least one number character");
        }
    }
}
