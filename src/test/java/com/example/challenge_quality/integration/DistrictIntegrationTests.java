package com.example.challenge_quality.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.repository.DistrictRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DistrictRepository districtRepository;

    @Test
    void createDistrictShouldReturnDistrict() throws Exception {
        District postDistrict = new District(null, "Copacabana", new BigDecimal(1000));
        District expectedDistrict = new District(null, "Copacabana", new BigDecimal(1000));
        int id = districtRepository.getAllDistricts().size() + 1;
        expectedDistrict.setId(id);

        mockMvc.perform(post("/district")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDistrict)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedDistrict)));
    }
}
