package com.example.challenge_quality.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;
import com.example.challenge_quality.repository.DistrictRepository;
import com.example.challenge_quality.repository.PropertyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyIntegrationTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private DistrictRepository districtRepository;

    Property getNewProperty(String nameDistrict) {
        Property property;
        String districtName = "Melicidade";
        if (nameDistrict != null) {
            districtName = nameDistrict;
        }
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, "Quarto", 2.0, 2.0));
        rooms.add(new Room(2, "Cozinha", 3.0, 3.0));
        rooms.add(new Room(3, "Banheiro", 1.0, 1.0));
        property = new Property("Melicidade", districtName, rooms);
        return property;
    }

    @Test
    void createPropertyShouldReturnProperty() throws Exception {

        Property propertyPost = getNewProperty(null);
        Property propertyExpected= getNewProperty(null);

        int id = propertyRepository.getAll().size() + 1;

        propertyExpected.setId(id);

        String jsonExpected = objectMapper.writeValueAsString(propertyExpected);
        String jsonPost = objectMapper.writeValueAsString(propertyPost);

        this.mockMvc
            .perform(
                post("/property")
                    .content(jsonPost)
                    .contentType(MediaType.APPLICATION_JSON)
                )
            .andExpect(status().isCreated())
            .andExpect(content().json(jsonExpected));
    }

    @Test
    void getPropertyValueShouldReturnValue() throws Exception {

        int randomNumber = (int) (Math.random() * 1000);
        String randomDistrictName = "Melicidade" + randomNumber;
        Property newProperty = getNewProperty(randomDistrictName);
        districtRepository.createDistrict(new District(null, randomDistrictName, new BigDecimal("1.00")));
        Property createdProperty = propertyRepository.createProperty(newProperty);

        Optional<BigDecimal> expectedValue = Optional.of(new BigDecimal("14.000"));

        String jsonExpected = objectMapper.writeValueAsString(expectedValue);

        this.mockMvc
            .perform(
                get("/property/value/{id}", createdProperty.getId())
                )
            .andExpect(status().isOk())
            .andExpect(content().json(jsonExpected));
    }
}
