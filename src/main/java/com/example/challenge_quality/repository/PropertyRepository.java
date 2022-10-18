package com.example.challenge_quality.repository;

import com.example.challenge_quality.model.Property;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.*;

@Repository
public class PropertyRepository {
    private final String path = "src/main/resources/Property.json";
    ObjectMapper mapper = new ObjectMapper();

    public List<Property> getAll() {
        List<Property> properties;

        try {
            properties = Arrays.asList(mapper.readValue(new File(path), Property[].class));
        } catch (Exception ex) {
            throw new RuntimeException("erro ao ler o arquivo");
        }

        return properties;
    }

    public Property createProperty(Property newProperty) {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Property> properties = getAll();

        properties = new ArrayList<>(properties);

        int id = properties.size() + 1;

        newProperty.setId(id);

        properties.add(newProperty);

        try {
            writer.writeValue(new File(path), properties);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return newProperty;
    }

    public Property getProperty(int id) {
        List<Property> properties = getAll();
        return properties.stream()
                .filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }
}