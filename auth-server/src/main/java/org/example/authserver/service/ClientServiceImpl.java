package org.example.authserver.service;

import org.example.authserver.model.Client;
import org.example.authserver.repository.ClientRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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
    public long clear() {
        long count = clientRepository.count();
        if (count > 0) {
            clientRepository.deleteAll();
        }
        return count;
    }
}
