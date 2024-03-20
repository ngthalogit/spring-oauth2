package org.example.authserver.controller;

import org.example.authserver.exception.NotFoundClientIdException;
import org.example.authserver.exception.NotFoundResponseTypeException;
import org.example.authserver.model.AccessTokenResponse;
import org.example.authserver.model.GrantAuthorizationResponse;
import org.example.authserver.service.AuthenticationService;
import org.example.authserver.service.ClientService;
import org.example.authserver.service.GrantServiceFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/apis/grant-type/")
public class AuthorizationController {
    private final ClientService clientService;
    private final AuthenticationService authenticationService;
    private final GrantServiceFactory grantServiceFactory;

    public AuthorizationController(ClientService clientService, AuthenticationService authenticationService, GrantServiceFactory grantServiceFactory) {
        this.clientService = clientService;
        this.authenticationService = authenticationService;
        this.grantServiceFactory = grantServiceFactory;
    }

    @GetMapping("/authorization")
    public ResponseEntity<GrantAuthorizationResponse> authorize(@RequestParam("client_id") String clientId,
                                                                @RequestParam("response_type") String responseType,
                                                                @RequestParam("redirect_uri") String redirectUri,
                                                                @RequestParam("state") String state,
                                                                @RequestParam("scope") String scope,
                                                                @RequestParam("username") String username,
                                                                @RequestParam("password") String password) throws NotFoundResponseTypeException, NotFoundClientIdException {
        authenticationService.authenticate(username, password);
        if (Objects.isNull(clientService.findByClientId(clientId))) {
            throw new NotFoundClientIdException(clientId);
        }
        return ResponseEntity.ok(grantServiceFactory.getGrantService(responseType).getGrantAuthorizationResponse(state, scope));
    }
    @PostMapping("/access-token")
    public ResponseEntity<AccessTokenResponse> token() {

        return null;
    }
}
