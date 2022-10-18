package com.example.challenge_quality.controller;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.service.DistrictService;
import com.example.challenge_quality.setup.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DistrictController.class)
public class DistrictControllerTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistrictService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createDistrictShouldReturnCreatedDistrict() throws Exception {
        BDDMockito.given(service.createDistrict(any(District.class)))
                .willReturn(district);

        String jsonExpected = objectMapper.writeValueAsString(district);

        this.mockMvc
                .perform(
                        post("/district")
                                .content(jsonExpected)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonExpected));

    }
}
