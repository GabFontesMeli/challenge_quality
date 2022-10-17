package com.example.challenge_quality.setup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import com.example.challenge_quality.model.District;
import com.example.challenge_quality.model.Property;
import com.example.challenge_quality.model.Room;



abstract public class BasePropertyTest {

    protected Property property;

    protected District district;

    @BeforeEach
    void setup() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, "Quarto", 2.0, 2.0));
        rooms.add(new Room(2, "Cozinha", 3.0, 3.0));
        rooms.add(new Room(3, "Banheiro", 1.0, 1.0));
        property = new Property(1, "Melicidade", "Lapa", rooms);
        district = new District(1, "Lapa", new BigDecimal("10.00"));
    }
}
