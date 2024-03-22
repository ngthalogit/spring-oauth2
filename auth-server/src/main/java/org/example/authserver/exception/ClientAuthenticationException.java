package org.example.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class ClientAuthenticationException extends Exception{
    public ClientAuthenticationException(String message) {
        super(message);
    }
}
