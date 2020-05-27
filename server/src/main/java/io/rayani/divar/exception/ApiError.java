package io.rayani.divar.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ApiError {
    private int status;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private String message;
    private String error;
    private String debugMessage;

    ApiError(){
        this.timeStamp = LocalDateTime.now();
    }
    ApiError(int status){
        this();
        this.status=status;
    }
   ApiError(int status, Throwable ex){
        this();
        this.status=status;
        this.message="Unexpected error";
        this.debugMessage=ex.getLocalizedMessage();
   }
   ApiError(int status, String message, Throwable ex){
        this();
        this.status=status;
        this.message = message;
        this.debugMessage=ex.getLocalizedMessage();
   }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
