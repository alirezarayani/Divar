package io.rayani.divar.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception{

    @ExceptionHandler(NotfoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFount(NotfoundException e){
        ApiError apiError =new ApiError(HttpStatus.NOT_FOUND.value());
        apiError.setMessage(e.getMessage());
        apiError.setError(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<ApiError>(apiError,new HttpHeaders(),HttpStatus.OK);
    }
}
