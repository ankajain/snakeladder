package com.deserve.exception;

public class GameOverException extends RuntimeException {

    public GameOverException(
        final String message) {
        super(message);
    }
}
