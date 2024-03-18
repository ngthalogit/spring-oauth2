package org.example.authserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundResponseTypeException extends Exception {
    public NotFoundResponseTypeException(String type) {
        super(type);
    }
}
