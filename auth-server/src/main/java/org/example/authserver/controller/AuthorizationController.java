package org.example.authserver.controller;

import org.example.authserver.exception.ClientAuthenticationException;
import org.example.authserver.exception.NotFoundClientIdException;
import org.example.authserver.exception.NotFoundGrantTypeException;
import org.example.authserver.exception.NotFoundResponseTypeException;
import org.example.authserver.model.*;
import org.example.authserver.service.AuthenticationService;
import org.example.authserver.service.ClientService;
import org.example.authserver.service.GrantServiceFactory;
import org.example.authserver.service.ResponseTypeFactory;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/apis/grant-type/")
public class AuthorizationController {
    private final ClientService clientService;
    private final AuthenticationService authenticationService;
    private final ResponseTypeFactory responseTypeFactory;
    private final GrantServiceFactory grantServiceFactory;

    public AuthorizationController(ClientService clientService, AuthenticationService authenticationService, ResponseTypeFactory responseTypeFactory, GrantServiceFactory grantServiceFactory) {
        this.clientService = clientService;
        this.authenticationService = authenticationService;
        this.responseTypeFactory = responseTypeFactory;
        this.grantServiceFactory = grantServiceFactory;
    }

    @PostMapping("/authorization")
    public ResponseEntity<GrantAuthorizationResponse> authorize(@RequestParam("client_id") String clientId,
                                                                @RequestParam("response_type") String responseType,
                                                                @RequestParam("redirect_uri") String redirectUri,
                                                                @RequestParam("state") String state,
                                                                @RequestParam("scope") String scope,
                                                                @RequestBody LoginRequest loginRequest) throws NotFoundResponseTypeException, NotFoundClientIdException {
        authenticationService.authenticate(loginRequest.username(), loginRequest.password());
        if (Objects.isNull(clientService.findByClientId(clientId))) {
            throw new NotFoundClientIdException(clientId);
        }
        return ResponseEntity.ok(responseTypeFactory.getResponseTypeService(responseType).getGrantAuthorizationResponse(state, scope));
    }

    @PostMapping(value = "/access-token", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<AccessTokenResponse> token(@RequestParam("grant_type") String grantType,
                                                     @RequestParam("client_id") String clientId,
                                                     @RequestParam("client_secret") String clientSecret,
                                                     @RequestParam("redirect_uri") String redirectUri,
                                                     @RequestParam("code") String code) throws ClientAuthenticationException, NotFoundClientIdException, NotFoundGrantTypeException {
        Client client = new Client(clientId, clientSecret);
        clientService.authenticate(client);
        return ResponseEntity.ok(grantServiceFactory.getGrantService(grantType).getAccessToken(code));
    }
}
