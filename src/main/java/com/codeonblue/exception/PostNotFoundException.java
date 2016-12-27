package com.codeonblue.exception;

public class PostNotFoundException extends Exception {

    public PostNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
