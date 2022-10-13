package com.example.challenge_quality.controller;

import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.service.IProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/property")
public class PropertyController {

    @Autowired
    private IProperty service;

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property){
        return new ResponseEntity<>(service.createProperty(property), HttpStatus.CREATED);
    }

    @GetMapping("/property-area/{id}")
    public ResponseEntity<Optional<Double>> getPropertyArea(@PathVariable Integer id){
        return new ResponseEntity<>(service.calculatePropertyArea(id), HttpStatus.OK);
    }
}
