package com.example.challenge_quality.dto;


import java.util.Objects;

import com.example.challenge_quality.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private String name;
    private Double area;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoomDTO)) {
            return false;
        }
        RoomDTO roomDTO = (RoomDTO) o;
        return Objects.equals(name, roomDTO.name) && Objects.equals(area, roomDTO.area);
    }

    public RoomDTO(Room room) {
        this.name = room.getName();
        this.area = room.getRoomArea();
    }
}


