package com.example.challenge_quality.dto;


import com.example.challenge_quality.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDTO {
    private String name;
    private Double area;

    public RoomDTO(Room room) {
        this.name = room.getName();
        this.area = room.getRoomArea();
    }
}


