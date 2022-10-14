package com.example.challenge_quality.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistrictsData {
    private Map<Integer, District> districts;

    private final static DistrictsData instance = new DistrictsData();

    private DistrictsData() {

    }

    public static DistrictsData getInstance() {
        return instance;
    }
}
