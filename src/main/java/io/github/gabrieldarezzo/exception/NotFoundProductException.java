package io.github.gabrieldarezzo.exception;

public class NotFoundProductException extends BusinessRuleException {
    public NotFoundProductException(String message) {
        super(message);
    }
}
