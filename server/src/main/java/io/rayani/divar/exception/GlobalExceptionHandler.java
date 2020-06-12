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
    @ExceptionHandler(EmailIsExists.class)
    public ResponseEntity<ApiError> isEmailExists(EmailIsExists e){
        ApiError apiError=new ApiError(HttpStatus.CONFLICT.value());
        apiError.setMessage(e.getMessage());
        apiError.setError(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<ApiError>(apiError,new HttpHeaders(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UsernameAndEmailNotCorrectException.class)
    public ResponseEntity<ApiError> emailAndPasswordIncorrect(UsernameAndEmailNotCorrectException e){
        ApiError apiError=new ApiError(HttpStatus.CONFLICT.value());
        apiError.setMessage(e.getMessage());
        apiError.setError(HttpStatus.NOT_FOUND.toString());
        return new ResponseEntity<ApiError>(apiError,new HttpHeaders(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<ApiError> passwordNotMatch(PasswordNotMatchException ex){
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST.value());
        apiError.setMessage(ex.getMessage());
        apiError.setError(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ApiError> roleNotFoundException(RoleNotFoundException ex){
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST.value());
        apiError.setMessage(ex.getMessage());
        apiError.setError(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
    }

}
