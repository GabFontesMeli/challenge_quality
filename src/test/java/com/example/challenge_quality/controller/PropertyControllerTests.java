package com.example.challenge_quality.controller;


import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.print.attribute.standard.Media;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.service.PropertyService;
import com.example.challenge_quality.setup.BasePropertyTest;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PropertyController.class)
public class PropertyControllerTests extends BasePropertyTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertyService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPropertyShouldReturnProperty() throws Exception {
        BDDMockito.given(service.createProperty(any(Property.class)))
        .willReturn(property);
        
        String json = objectMapper.writeValueAsString(property);

        this.mockMvc
            .perform(
                post("/property")
                    .content(json)
                    .contentType(MediaType.APPLICATION_JSON)
                )
            .andExpect(status().isCreated())
            .andExpect(content().json(json));

    }
}
