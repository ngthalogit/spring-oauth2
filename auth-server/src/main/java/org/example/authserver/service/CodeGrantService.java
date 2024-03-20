package org.example.authserver.service;

import org.example.authserver.model.AccessTokenResponse;
import org.example.authserver.model.GrantAuthorizationResponse;
import org.example.authserver.tools.JwtHelper;
import org.springframework.stereotype.Service;

@Service
public class CodeGrantService implements GrantService {
    @Override
    public GrantAuthorizationResponse getGrantAuthorizationResponse(String state, String scope) {
        GrantAuthorizationResponse response = new GrantAuthorizationResponse();
        response.setState(state);
        response.setCode(JwtHelper.generateJwtToken(scope));
        return response;
    }
//    @Override
//    public AccessTokenResponse authorize(AuthorizationUrl request) {
//        return null;
//    }
}
