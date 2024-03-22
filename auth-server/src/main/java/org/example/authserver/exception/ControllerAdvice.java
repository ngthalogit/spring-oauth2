package org.example.authserver.exception;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
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

    @ExceptionHandler(ClientAuthenticationException.class)
    public ResponseEntity<ErrorMessage> clientAuthenticationException(ClientAuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage("Client authentication failed: " + e.getMessage()));
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ErrorMessage> invalidCodeAuthorizationException(MalformedJwtException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage("Invalid code authorization: " + e.getMessage()));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorMessage> expiredJwtException(ExpiredJwtException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage("Expired token: " + e.getMessage()));
    }

    @ExceptionHandler(UnsupportedJwtException.class)
    public ResponseEntity<ErrorMessage> unsupportedJwtException(UnsupportedJwtException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorMessage("Unsupported token: " + e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> illegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage("Illegal argument: " + e.getMessage()));
    }

    @ExceptionHandler(NotFoundGrantTypeException.class)
    public ResponseEntity<ErrorMessage> notFoundGrantTypeException(NotFoundGrantTypeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Not found grant type: " + e.getMessage()));
    }

}
