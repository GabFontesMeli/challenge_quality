package com.example.challenge_quality.service;

import com.example.challenge_quality.exceptions.DistrictAlreadyExistsException;
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

        District teste = districtRepository.getDistrictByName(district.getName());

        if (teste != null) {
            throw new DistrictAlreadyExistsException("Bairro já existe.");
        }
        return districtRepository.createDistrict(district);
    }

}
