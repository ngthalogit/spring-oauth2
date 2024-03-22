package org.example.authserver.service;

import org.example.authserver.exception.NotFoundResponseTypeException;
import org.springframework.stereotype.Service;

import static org.example.authserver.constant.ResponseType.*;


@Service
public class ResponseTypeFactoryImpl implements ResponseTypeFactory {
    @Override
    public ResponseTypeService getResponseTypeService(String type) throws NotFoundResponseTypeException {
        return switch (from(type)) {
            case CODE -> new CodeResponseTypeService();
            case TOKEN, UNKNOWN -> throw new NotFoundResponseTypeException(type);
        };
    }
}
