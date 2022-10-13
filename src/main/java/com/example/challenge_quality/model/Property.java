package com.example.challenge_quality.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @NotBlank(message = "O nome da propriedade não pode estar vazio")
    @Size(min = 3, max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "\\b[A-Z][a-z]+(?!\\s)", message = "O nome da propriedade deve começar com uma letra maiúscula")
    private String name;

    @NotBlank(message = "O bairro não pode estar vazio")
    @Size(min = 3, max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres")
    private String district;

    private List<@Valid Room> rooms;
}
