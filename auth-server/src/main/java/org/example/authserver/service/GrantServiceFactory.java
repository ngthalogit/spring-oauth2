package org.example.authserver.service;

import org.example.authserver.exception.NotFoundGrantTypeException;

public interface GrantServiceFactory {
    GrantService getGrantService(String type) throws NotFoundGrantTypeException;
}
