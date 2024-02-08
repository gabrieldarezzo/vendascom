package io.github.gabrieldarezzo.exception;

public class NotFoundCustomerException extends BusinessRuleException {
    public NotFoundCustomerException(String message) {
        super(message);
    }
}
