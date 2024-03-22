package org.example.authserver.service;

import org.example.authserver.model.AccessTokenResponse;

public interface GrantService {
    AccessTokenResponse getAccessToken(String code);
}
