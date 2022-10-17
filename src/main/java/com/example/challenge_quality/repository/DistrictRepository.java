package com.example.challenge_quality.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import com.example.challenge_quality.model.District;

@Repository
public class DistrictRepository {
    private final String path = "src/main/resources/Districts.json";
    ObjectMapper mapper = new ObjectMapper();

    public List<District> getAllDistricts() {
        List<District> districts;

        try {
            districts = Arrays.asList(mapper.readValue(new File(path), District[].class));
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return districts;
    }

    public District getDistrict(Integer id) {
        List<District> districts = getAllDistricts();
        return districts.stream()
                .filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public District getDistrictByName(String name) {
        List<District> districts = getAllDistricts();
        return districts.stream()
                .filter(d -> d.getName().equals(name)).findFirst()
                .orElse(null);
    }

    /*
    Esse método cadastra um novo district.
     */
    public District createDistrict(District newDistrict) {
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<District> districts = getAllDistricts();
        newDistrict.setId(districts.size()+1);
        districts = new ArrayList<>(districts); // reinstanciando a lista que era imutavel, para uma lista igual, só que mutavel.
        districts.add(newDistrict);
        try {
            writer.writeValue(new File(path), districts);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return newDistrict;
    }
}
