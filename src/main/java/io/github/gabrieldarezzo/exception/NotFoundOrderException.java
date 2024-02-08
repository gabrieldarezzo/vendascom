package io.github.gabrieldarezzo.exception;

public class NotFoundOrderException extends BusinessRuleException {
    public NotFoundOrderException(String message) {
        super(message);
    }
}
