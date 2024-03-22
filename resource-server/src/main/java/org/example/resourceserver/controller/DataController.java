package org.example.resourceserver.controller;

import org.example.resourceserver.model.Data;
import org.example.resourceserver.model.LoginRequest;
import org.example.resourceserver.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/data")
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public ResponseEntity<List<Data>> getData(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(dataService.getAll());
    }
}
