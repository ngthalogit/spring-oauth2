package org.example.authserver.service;

import org.example.authserver.exception.NotFoundGrantTypeException;
import org.springframework.stereotype.Service;

import static org.example.authserver.constant.GrantType.from;

@Service
public class GrantServiceFactoryImpl implements GrantServiceFactory {
    @Override
    public GrantService getGrantService(String type) throws NotFoundGrantTypeException {
        return switch (from(type)) {
            case AUTHORIZATION_CODE -> new CodeGrantService();
            case TOKEN, UNKNOWN -> throw new NotFoundGrantTypeException(type);
        };
    }
}
