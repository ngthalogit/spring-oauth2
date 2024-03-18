package org.example.authserver.repository;

import org.example.authserver.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByClientId(String clientId);
}
