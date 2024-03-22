package org.example.authserver.service;

import org.example.authserver.model.AccessTokenResponse;
import org.example.authserver.tools.JwtHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeGrantService implements GrantService {
    @Override
    public AccessTokenResponse getAccessToken(String code) {
        String scope = JwtHelper.verifyCodeAuthorization(code);
        List<String> jwt = JwtHelper.generateAccessToken(scope);
        AccessTokenResponse response = new AccessTokenResponse.Builder()
                .withAccessToken(jwt.get(0))
                .withExpiresIn(jwt.get(1))
                .withRefreshToken("")
                .withScope(scope)
                .withTokenType("Bearer")
                .build();
        return response;
    }
}
