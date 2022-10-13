package com.example.challenge_quality.service;

import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;
import com.example.challenge_quality.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyService implements IProperty{

    @Autowired
    private PropertyRepository repository;

    @Override
    public Property createProperty(Property property) {
        return repository.createProperty(property);
    }

    public Optional<Double> calculatePropertyArea(Integer id) {
        Property property = repository.getProperty(id);
        return property.getRooms().stream().map(Room::getRoomArea).reduce(Double::sum);
    }
}
