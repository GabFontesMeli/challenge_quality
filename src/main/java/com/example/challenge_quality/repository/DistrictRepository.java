package com.example.challenge_quality.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.util.NumberGenerator;

@Repository
public class DistrictRepository {
    
    Map<Integer, District> districts = new HashMap<>();

    District lapa = new District((NumberGenerator.getInstance().getNext()), "Lapa", new BigDecimal("100.00"));
    District rocinha = new District((NumberGenerator.getInstance().getNext()), "Rocinha", new BigDecimal("90.00"));
    District copacabana = new District((NumberGenerator.getInstance().getNext()), "Copacabana", new BigDecimal("10000.00"));
    District liberdade = new District((NumberGenerator.getInstance().getNext()), "Liberdade", new BigDecimal("250.00"));


    public District createDistrict(District district) {
        districts.put(NumberGenerator.getInstance().getNext(), district);
        System.out.println(districts);

        districts.put((NumberGenerator.getInstance().getNext()), lapa);
        districts.put((NumberGenerator.getInstance().getNext()), rocinha);
        districts.put((NumberGenerator.getInstance().getNext()), copacabana);
        districts.put((NumberGenerator.getInstance().getNext()), liberdade);

        return district;
    }

    public District getDistrict(Integer id){
        return districts.get(id);
    }
}
