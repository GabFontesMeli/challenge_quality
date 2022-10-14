package com.example.challenge_quality.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Integer id;

    @NotBlank(message = "O campo não pode estar vazio.")
    @Size(min = 3, max = 30, message = "O comprimento do nome do cômodo deve ter entre 3 e 30 caracteres.")
    @Pattern(regexp = "\\p{Upper}.*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String name;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @DecimalMax(value = "25.0")
    private Double width;

    @NotNull(message = "O comprimento do cômodo não pode estar vazia.")
    @DecimalMax(value = "33.0")
    private Double length;

    @JsonIgnore
    public double getRoomArea() {
        return width * length;
    }
}
