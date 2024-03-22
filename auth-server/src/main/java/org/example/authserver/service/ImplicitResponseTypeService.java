package org.example.authserver.service;

import org.example.authserver.model.GrantAuthorizationResponse;
import org.springframework.stereotype.Service;

@Service
public class ImplicitResponseTypeService implements ResponseTypeService {
    @Override
    public GrantAuthorizationResponse getGrantAuthorizationResponse(String state, String scope) {
        return null;
    }
}
