package ru.sber.server.exception;

public class ValidationFailedException extends RuntimeException {

    private static final String MESSAGE = "Validation Failed";

    public ValidationFailedException() {
        super(MESSAGE);
    }
}
