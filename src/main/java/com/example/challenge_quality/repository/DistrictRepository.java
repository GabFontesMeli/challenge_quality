package com.example.challenge_quality.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.model.DistrictsData;

@Repository
public class DistrictRepository {

    public District getDistrict(Integer id) {
        return DistrictsData.getInstance().getDistricts().get(id);
    }

    public District getDistrictByName(String name) {
        Map<Integer, District> districts = DistrictsData.getInstance().getDistricts();
        return districts.entrySet()
            .stream().filter(district -> district.getValue().getName().equals(name)).findFirst().get().getValue();
    }
}
