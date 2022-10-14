package com.example.challenge_quality.service;

import com.example.challenge_quality.dto.RoomDTO;
import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProperty {

    Property createProperty(Property property);

    Optional<Room> getPropertyBiggestRoom(Integer id);

    List<RoomDTO> getRoomsArea(Integer id);

    Optional<Double> calculatePropertyArea(Integer id);

    Optional<BigDecimal> calculatePropertyValue(Integer id);
}
