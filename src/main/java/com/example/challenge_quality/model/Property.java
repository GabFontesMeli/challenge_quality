package com.example.challenge_quality.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    private Integer id;

    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Size(min = 3, max = 30, message = "O comprimento do nome da propriedade deve ter entre 3 e 30 caracteres.")
    @Pattern(regexp = "\\p{Upper}.*", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String name;

    @NotBlank(message = "O bairro não pode estar vazio")
    @Size(min = 3, max = 45, message = "O comprimento do nome do bairro deve ter entre 3 e 45 caracteres.")
    @Pattern(regexp = "\\p{Upper}.*", message = "O nome do bairro deve começar com uma letra maiúscula.")
    private String district;

    private List<@Valid Room> rooms;

    public Property(String name, String district, List<Room> rooms) {
        this.name = name;
        this.district = district;
        this.rooms = rooms;
    }
}
