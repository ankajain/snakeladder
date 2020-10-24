package com.deserve.exception;

public class InvalidPlayerException extends RuntimeException {

    public InvalidPlayerException(
        final String name) {
        super(name);
    }

    public InvalidPlayerException() {
        super();
    }
}
