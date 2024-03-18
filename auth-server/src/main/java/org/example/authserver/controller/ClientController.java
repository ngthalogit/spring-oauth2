package org.example.authserver.controller;

import org.example.authserver.model.Client;
import org.example.authserver.service.ClientService;
import org.example.authserver.tools.ClientSecretGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/registry")
    public ResponseEntity<Client> register() {
        String clientId = ClientSecretGenerator.random(25);
        String clientSecret = ClientSecretGenerator.random(30);
        while (Objects.nonNull(clientService.findByClientId(clientId))) {
            clientId = ClientSecretGenerator.random(25);
        }
        Client client = clientService.registerClient(clientId, clientSecret);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/clear")
    public ResponseEntity<String> clear() {
        long clear = clientService.clear();
        if (clear > 0) {
            return ResponseEntity.ok("Successfully cleared %d clients".formatted(clear));
        }
        return ResponseEntity.ok("There is no client need to be cleared");
    }


}
