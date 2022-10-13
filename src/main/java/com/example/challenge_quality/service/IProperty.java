package com.example.challenge_quality.service;

import com.example.challenge_quality.model.Property;

import java.util.Optional;

public interface IProperty {

    Property createProperty(Property property);

    Optional<Double> calculatePropertyArea(Integer id);
}
