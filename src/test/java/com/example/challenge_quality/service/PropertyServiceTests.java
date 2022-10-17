package com.example.challenge_quality.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.challenge_quality.dto.RoomDTO;
import com.example.challenge_quality.model.District;
import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;
import com.example.challenge_quality.repository.DistrictRepository;
import com.example.challenge_quality.repository.PropertyRepository;

import lombok.extern.log4j.Log4j2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {
    
    @InjectMocks
    private PropertyService service;

    // TODO: alterar nome para propertyrepository
    @Mock
    private PropertyRepository repository;

    @Mock
    private DistrictRepository districtRepository;

    private Property property;

    private District district;

    @BeforeEach
    void setup() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, "Quarto", 2.0, 2.0));
        rooms.add(new Room(2, "Cozinha", 3.0, 3.0));
        rooms.add(new Room(3, "Banheiro", 1.0, 1.0));
        property = new Property(1, "Melicidade", "Lapa", rooms);
        district = new District(1, "Lapa", new BigDecimal("10.00"));
    }

    @Test
    void getRoomsAreaShouldReturnListOfRoomDTO() {
        BDDMockito.given(repository.getProperty(anyInt())).willReturn(property);
        List<RoomDTO> result = new ArrayList<>();
        result.add(new RoomDTO("Quarto", 4.0));
        result.add(new RoomDTO("Cozinha", 9.0));
        result.add(new RoomDTO("Banheiro", 1.0));

        List<RoomDTO> rooms = service.getRoomsArea(1);

        assertThat(rooms).hasSameElementsAs(result);
    }

    @Test
    void calculatePropertyValueShouldReturnCorrectPropertyValue() {

        BDDMockito.given(repository.getProperty(anyInt())).willReturn(property);
        BDDMockito.given(districtRepository.getDistrictByName(anyString())).willReturn(district);
        Double propertyArea = 14.0;
        Optional<BigDecimal> expected = Optional.of(district.getValueDistrictM2()
            .multiply(BigDecimal.valueOf(propertyArea)));

        Optional<BigDecimal> result = service.calculatePropertyValue(1);

        assertThat(result).isEqualTo(expected);
    }
}
