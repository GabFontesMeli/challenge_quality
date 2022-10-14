package com.example.challenge_quality.service;

import com.example.challenge_quality.dto.RoomDTO;
import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;
import com.example.challenge_quality.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyService implements IProperty{

    @Autowired
    private PropertyRepository repository;

    @Override
    public Property createProperty(Property property) {
        return repository.createProperty(property);
    }

    @Override
    public Optional<Room> getPropertyBiggestRoom(Integer id) {
        Property property = repository.getProperty(id);
        return property.getRooms().stream().max(Comparator.comparing(Room::getRoomArea));
    }

    public List<RoomDTO> getRoomsArea(Integer id) {
        Property property = repository.getProperty(id);
        return property.getRooms().stream().map(RoomDTO::new).collect(Collectors.toList());
    }

    public Optional<Double> calculatePropertyArea(Integer id) {
        Property property = repository.getProperty(id);
        return property.getRooms().stream().map(Room::getRoomArea).reduce(Double::sum);
    }
}
