package com.example.challenge_quality.service;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrict {

    @Autowired
    public DistrictRepository districtRepository;

    @Override
    public District createDistrict(District district) {
        return districtRepository.createDistrict(district);
    }

}
