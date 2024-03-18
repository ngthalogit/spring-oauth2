package org.example.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundClientIdException extends Exception{
    public NotFoundClientIdException(String clientId) {
        super(clientId);
    }
}
