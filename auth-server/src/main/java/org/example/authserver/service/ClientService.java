package org.example.authserver.service;

import org.example.authserver.exception.ClientAuthenticationException;
import org.example.authserver.exception.NotFoundClientIdException;
import org.example.authserver.model.Client;

public interface ClientService {
    Client findByClientId(String clientId);

    Client registerClient(String clientId, String clientSecret);

    void authenticate(Client client) throws ClientAuthenticationException, NotFoundClientIdException;
}
