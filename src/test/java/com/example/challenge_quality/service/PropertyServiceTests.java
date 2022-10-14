package com.example.challenge_quality.service;

import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.challenge_quality.dto.RoomDTO;
import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;
import com.example.challenge_quality.repository.PropertyRepository;

import lombok.extern.log4j.Log4j2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
@ExtendWith(MockitoExtension.class)
public class PropertyServiceTests {
    
    @InjectMocks
    private PropertyService service;

    @Mock
    private PropertyRepository repository;

    private Property property;

    @BeforeEach
    void setup() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, "Quarto", 2.0, 2.0));
        rooms.add(new Room(2, "Cozinha", 3.0, 3.0));
        rooms.add(new Room(3, "Banheiro", 1.0, 1.0));
        property = new Property(1, "Melicidade", "Lapa", rooms);
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
}
