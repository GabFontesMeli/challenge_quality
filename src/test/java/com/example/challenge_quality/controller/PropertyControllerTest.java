package com.example.challenge_quality.controller;


import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.example.challenge_quality.dto.RoomDTO;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.service.PropertyService;
import com.example.challenge_quality.setup.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest(PropertyController.class)
public class PropertyControllerTest extends BaseTest {
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

    @Test
    void getRoomsAreaShouldReturnRoomsArea() throws Exception {
        List<RoomDTO> expectedList = new ArrayList<>();
        expectedList.add(new RoomDTO(property.getRooms().get(0)));
        expectedList.add(new RoomDTO(property.getRooms().get(1)));
        expectedList.add(new RoomDTO(property.getRooms().get(2)));

        BDDMockito.given(service.getRoomsArea(anyInt()))
                .willReturn(expectedList);

        String jsonExpected = objectMapper.writeValueAsString(expectedList);

        this.mockMvc
                .perform(
                        get("/property/rooms-area/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().json(jsonExpected));
    }

    @Test
    void getPropertyAreaShouldReturnPropertyArea() throws Exception {
        Double expectedArea = 14.0;
        BDDMockito.given(service.calculatePropertyArea(anyInt()))
                .willReturn(Optional.of(expectedArea));

        String jsonExpected = objectMapper.writeValueAsString(expectedArea);

        this.mockMvc
                .perform(
                        get("/property/area/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().json(jsonExpected));
    }

    @Test
    void getPropertyValueShouldReturnPropertyValue() throws Exception {
        Optional<BigDecimal> expectedValue = Optional.of(new BigDecimal("14.0"));

        BDDMockito.given(service.calculatePropertyValue(anyInt()))
        .willReturn(expectedValue);

        String jsonExpected = objectMapper.writeValueAsString(expectedValue);

        this.mockMvc
                .perform(
                        get("/property/value/{id}", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk())
                .andExpect(content().json(jsonExpected));
    }
}
