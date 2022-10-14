package com.example.challenge_quality.dto;


import com.example.challenge_quality.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private String name;
    private Double area;

    public RoomDTO(Room room) {
        this.name = room.getName();
        this.area = room.getRoomArea();
    }
}


