package com.example.challenge_quality.service;

import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;

import javax.validation.Valid;
import java.util.Optional;

public interface IProperty {

    Property createProperty(Property property);

    Optional<@Valid Room> getPropertyBiggestRoom(Integer id);

    Optional<Double> calculatePropertyArea(Integer id);
}
