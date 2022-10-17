package com.example.challenge_quality.service;

import static org.mockito.ArgumentMatchers.any;
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
import com.example.challenge_quality.setup.SetupProperty;

import lombok.extern.log4j.Log4j2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests extends SetupProperty {
    
    @InjectMocks
    private PropertyService service;

    // TODO: alterar nome para propertyrepository
    @Mock
    private PropertyRepository repository;

    @Mock
    private DistrictRepository districtRepository;


    @Test
    void createPropertyShouldReturnCreatedProperty() {
       BDDMockito.given(repository.createProperty(any(Property.class))).willReturn(property);
       Property result = service.createProperty(property);

       assertThat(result).isEqualTo(property);
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
    void calculatePropertyAreaShouldReturnCorrectPropertyArea() {

        Optional<Double> propertyArea = Optional.of(14.0);
        BDDMockito.given(repository.getProperty(anyInt())).willReturn(property);
        
        Optional<Double> result = service.calculatePropertyArea(1);

        assertThat(result).isEqualTo(propertyArea);
    }

    @Test
    void calculatePropertyValueShouldReturnCorrectPropertyValue() {

        Double propertyArea = 14.0;
        BDDMockito.given(repository.getProperty(anyInt())).willReturn(property);
        BDDMockito.given(districtRepository.getDistrictByName(anyString())).willReturn(district);
        Optional<BigDecimal> expected = Optional.of(district.getValueDistrictM2()
            .multiply(BigDecimal.valueOf(propertyArea)));

        Optional<BigDecimal> result = service.calculatePropertyValue(1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getPropertyBiggestRoomShouldReturnPropertyBiggestRoom() {

        Optional<Room> biggestRoom = Optional.of(property.getRooms().get(1));
        BDDMockito.given(repository.getProperty(anyInt())).willReturn(property);

        Optional<Room> result = service.getPropertyBiggestRoom(1);

        assertThat(result).isEqualTo(biggestRoom);
    }
    

    
}
