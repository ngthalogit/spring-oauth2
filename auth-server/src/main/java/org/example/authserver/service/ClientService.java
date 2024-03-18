package org.example.authserver.service;

import org.example.authserver.model.Client;

public interface ClientService {
    Client findByClientId(String clientId);

    Client registerClient(String clientId, String clientSecret);

    long clear();
}
