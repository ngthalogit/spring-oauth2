package org.example.authserver.exception;


import org.example.authserver.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundResponseTypeException.class)
    public ResponseEntity<ErrorMessage> responseTypeNotFoundException(NotFoundResponseTypeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Not found response_type: " + e.getMessage()));
    }
    @ExceptionHandler(NotFoundClientIdException.class)
    public ResponseEntity<ErrorMessage> responseTypeNotFoundException(NotFoundClientIdException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Not found client_id: " + e.getMessage()));
    }
}
