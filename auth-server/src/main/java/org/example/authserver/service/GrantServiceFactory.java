package org.example.authserver.service;

import org.example.authserver.exception.NotFoundResponseTypeException;

public interface GrantServiceFactory {
    GrantService getGrantService(String type) throws NotFoundResponseTypeException;
}
