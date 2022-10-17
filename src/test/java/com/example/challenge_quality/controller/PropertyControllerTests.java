package com.example.challenge_quality.controller;


import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.print.attribute.standard.Media;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.challenge_quality.model.Room;
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

import java.util.Optional;

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

    @Test
    void getPropertyBiggestRoomShouldReturnPropertyBiggestRoom() throws Exception {
        BDDMockito.given(service.getPropertyBiggestRoom(anyInt()))
                .willReturn(Optional.of(property.getRooms().get(1)));

        String jsonExpected = objectMapper.writeValueAsString(property.getRooms().get(1));

        this.mockMvc
                .perform(
                        get("/property/biggest-room/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().json(jsonExpected));
    }
}
