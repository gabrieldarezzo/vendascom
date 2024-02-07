package io.github.gabrieldarezzo.exception;

public class EmptyItemOrderException extends RuntimeException {
    public EmptyItemOrderException(String message) {
        super(message);
    }
}
