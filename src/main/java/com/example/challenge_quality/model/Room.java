package com.example.challenge_quality.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @NotBlank(message = "O campo não pode estar vazio")
    @Size(min = 3, max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres")
    @Pattern(regexp = "\\b[A-Z][a-z]+(?!\\s)", message = "O nome do cômodo deve começar com uma letra maiúscula")
    private String name;

    @NotNull(message = "A largura do cômodo não pode estar vazia")
    @DecimalMax(value = "25.0")
    private double width;

    @NotNull(message = "O comprimento do cômodo não pode estar vazia")
    @DecimalMax(value = "33.0")
    private double length;
}
