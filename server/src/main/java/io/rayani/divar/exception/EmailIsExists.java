package io.rayani.divar.exception;

public class EmailIsExists extends Throwable {
    private String message;
    public EmailIsExists(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
