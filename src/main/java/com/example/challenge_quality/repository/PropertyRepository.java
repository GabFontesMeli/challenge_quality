package com.example.challenge_quality.repository;

import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.util.NumberGenerator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PropertyRepository {

    Map<Integer, Property> properties = new HashMap<>();

    public Property createProperty(Property property) {
        properties.put(NumberGenerator.getInstance().getNext(), property);
        System.out.println(properties);
        return property;
    }

    public Property getProperty(Integer id){
        return properties.get(id);
    }
}
