package org.example.authserver.service;

import org.example.authserver.model.AccessTokenResponse;
import org.example.authserver.model.GrantAuthorizationResponse;
import org.springframework.stereotype.Service;

@Service
public class ImplicitGrantService implements GrantService{
    @Override
    public GrantAuthorizationResponse getGrantAuthorizationResponse(String state, String scope) {
        return null;
    }
//    @Override
//    public AccessTokenResponse authorize(AuthorizationUrl request) {
//        return null;
//    }
}
