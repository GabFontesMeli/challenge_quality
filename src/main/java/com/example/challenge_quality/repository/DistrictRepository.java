package com.example.challenge_quality.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.util.NumberGenerator;

@Repository
public class DistrictRepository {
    
    Map<Integer, District> districts = new HashMap<>();

    public District createDistrict(District district) {
        districts.put(NumberGenerator.getInstance().getNext(), district);
        System.out.println(districts);
        return district;
    }

    public District getDistrict(Integer id){
        return districts.get(id);
    }
}
