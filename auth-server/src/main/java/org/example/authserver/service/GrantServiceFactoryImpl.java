package org.example.authserver.service;

import org.example.authserver.constant.GrantType;
import org.example.authserver.exception.NotFoundResponseTypeException;
import org.springframework.stereotype.Service;

import static org.example.authserver.constant.GrantType.*;


@Service
public class GrantServiceFactoryImpl implements GrantServiceFactory {
    @Override
    public GrantService getGrantService(String type) throws NotFoundResponseTypeException {
        return switch (from(type)) {
            case CODE -> new CodeGrantService();
            case TOKEN, UNKNOWN -> throw new NotFoundResponseTypeException(type);
        };
    }
}
