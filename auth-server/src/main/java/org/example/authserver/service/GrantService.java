package org.example.authserver.service;

import org.example.authserver.model.AccessTokenResponse;
import org.example.authserver.model.GrantAuthorizationResponse;

public interface GrantService {
    GrantAuthorizationResponse getAuthorizationResponse(String state, String scope);
//    AccessTokenResponse authorize(AuthorizationUrl request);
}
