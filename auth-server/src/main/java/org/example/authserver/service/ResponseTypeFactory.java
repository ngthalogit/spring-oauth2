package org.example.authserver.service;

import org.example.authserver.exception.NotFoundResponseTypeException;

public interface ResponseTypeFactory {
    ResponseTypeService getResponseTypeService(String type) throws NotFoundResponseTypeException;
}
