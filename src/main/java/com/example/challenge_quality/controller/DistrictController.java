package com.example.challenge_quality.controller;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.service.IDistrict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/district")
@Validated

public class DistrictController {
    @Autowired
    public IDistrict service;

    @PostMapping
    public ResponseEntity<District> createDistrict(@Valid @RequestBody District district){
        return new ResponseEntity<>(service.createDistrict(district), HttpStatus.CREATED);
    }

}
