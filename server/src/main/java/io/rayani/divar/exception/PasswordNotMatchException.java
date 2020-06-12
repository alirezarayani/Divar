package io.rayani.divar.exception;

public class PasswordNotMatchException extends Exception {
    private String message;

    public PasswordNotMatchException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
