package org.example.authserver.service;

import org.example.authserver.exception.ClientAuthenticationException;
import org.example.authserver.exception.NotFoundClientIdException;
import org.example.authserver.model.Client;
import org.example.authserver.repository.ClientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Client findByClientId(String clientId) {
        return clientRepository.findByClientId(clientId);
    }

    @Override
    public Client registerClient(String clientId, String clientSecret) {
        return clientRepository.save(new Client(clientId, clientSecret));
    }
    @Override
    public void authenticate(Client client) throws ClientAuthenticationException, NotFoundClientIdException {
        Client existingClient = this.findByClientId(client.getClientId());
        if (Objects.isNull(existingClient)) {
            throw new NotFoundClientIdException(client.getClientId());
        }
        if (!existingClient.getClientSecret().equals(client.getClientSecret())) {
            throw new ClientAuthenticationException(client.getClientId());
        }
    }
}
