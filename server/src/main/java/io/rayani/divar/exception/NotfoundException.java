package io.rayani.divar.exception;

public class NotfoundException extends Exception{
    String message;

    public NotfoundException(String message) {
       this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
