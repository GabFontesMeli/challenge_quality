package com.example.challenge_quality;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.model.DistrictsData;
import com.example.challenge_quality.util.NumberGenerator;
@SpringBootApplication
public class ChallengeQualityApplication {

    public static void main(String[] args) {
        
        Map<Integer, District> districts = new HashMap<>();
        District lapa = new District((NumberGenerator.getInstance().getNext()), "Lapa", new BigDecimal("100.00"));
        District rocinha = new District((NumberGenerator.getInstance().getNext()), "Rocinha", new BigDecimal("90.00"));
        District copacabana = new District((NumberGenerator.getInstance().getNext()), "Copacabana", new BigDecimal("10000.00"));
        District liberdade = new District((NumberGenerator.getInstance().getNext()), "Liberdade", new BigDecimal("250.00"));
        districts.put((NumberGenerator.getInstance().getNext()), lapa);
        districts.put((NumberGenerator.getInstance().getNext()), rocinha);
        districts.put((NumberGenerator.getInstance().getNext()), copacabana);
        districts.put((NumberGenerator.getInstance().getNext()), liberdade);
        
        DistrictsData.getInstance().setDistricts(districts);
        
        SpringApplication.run(ChallengeQualityApplication.class, args);
    
    }

}
