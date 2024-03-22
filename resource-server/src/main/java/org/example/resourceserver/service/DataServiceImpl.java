package org.example.resourceserver.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.resourceserver.model.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    private final Logger LOGGER = LoggerFactory.getLogger(DataServiceImpl.class);
    private final ObjectMapper objectMapper;

    public DataServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Data> getAll() {
        try {
            return objectMapper.readValue(new File("resource-server/src/main/resources/json/data.json"), new TypeReference<>() {
            });
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return List.of();
    }
}
