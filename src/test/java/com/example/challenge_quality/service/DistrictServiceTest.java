package com.example.challenge_quality.service;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.repository.DistrictRepository;
import com.example.challenge_quality.setup.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class DistrictServiceTest extends BaseTest {

    @InjectMocks
    private DistrictServiceImpl service;

    @Mock
    private DistrictRepository repository;

    @Test
    void createDistrictShouldReturnCreatedDistrict() {
        BDDMockito.given(repository.createDistrict(any(District.class))).willReturn(district);
        District result = service.createDistrict(district);

        assertThat(result).isEqualTo(district);
    }
}
