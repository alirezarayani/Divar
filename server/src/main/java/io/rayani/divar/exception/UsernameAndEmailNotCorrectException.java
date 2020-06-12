package io.rayani.divar.exception;

public class UsernameAndEmailNotCorrectException  extends RuntimeException{
    private String message;

    public UsernameAndEmailNotCorrectException(String message) {
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
