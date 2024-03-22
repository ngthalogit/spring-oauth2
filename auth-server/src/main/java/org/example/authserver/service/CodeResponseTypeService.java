package org.example.authserver.service;

import org.example.authserver.model.GrantAuthorizationResponse;
import org.example.authserver.tools.JwtHelper;
import org.springframework.stereotype.Service;

@Service
public class CodeResponseTypeService implements ResponseTypeService {
    @Override
    public GrantAuthorizationResponse getGrantAuthorizationResponse(String state, String scope) {
        GrantAuthorizationResponse response = new GrantAuthorizationResponse();
        response.setState(state);
        response.setCode(JwtHelper.generateCodeAuthorization(scope));
        return response;
    }
//    @Override
//    public AccessTokenResponse authorize(AuthorizationUrl request) {
//        return null;
//    }
}
