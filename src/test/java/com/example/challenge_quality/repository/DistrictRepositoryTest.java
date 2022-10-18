package com.example.challenge_quality.repository;

import com.example.challenge_quality.model.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DistrictRepositoryTest {

    @Autowired
    public DistrictRepository districtRepository;

    @Test
    public void createDistrict() {
        District district = new District();
        district.setName("test");
        district.setValueDistrictM2(new BigDecimal("1000.00"));

        districtRepository.createDistrict(district);
        District queryResult = districtRepository.getDistrictByName("test");

        assertThat(queryResult).isNotNull();
        assertThat(queryResult.getName()).isEqualTo("test");
    }
}
