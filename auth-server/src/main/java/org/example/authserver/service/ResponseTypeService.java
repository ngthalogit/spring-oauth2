package org.example.authserver.service;

import org.example.authserver.model.GrantAuthorizationResponse;

public interface ResponseTypeService {
    GrantAuthorizationResponse getGrantAuthorizationResponse(String state, String scope);
}
