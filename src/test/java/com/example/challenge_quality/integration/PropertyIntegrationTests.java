package com.example.challenge_quality.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.challenge_quality.setup.BasePropertyTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyIntegrationTests extends BasePropertyTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPropertyShouldReturnProperty() throws Exception {

        String jsonExpected = objectMapper.writeValueAsString(property);

        this.mockMvc
            .perform(
                post("/property")
                    .content(jsonExpected)
                    .contentType(MediaType.APPLICATION_JSON)
                )
            .andExpect(status().isCreated())
            .andExpect(content().json(jsonExpected));
    }
}
