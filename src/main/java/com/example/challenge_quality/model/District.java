package com.example.challenge_quality.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class District {

    private Integer id;

    @NotBlank(message = "O bairro não pode estar vazio")
    @Size(min = 3, max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres")
    private String name;

    @NotNull(message = "O valor do metro quadrado do bairro não pode estar vazio")
    @Digits(integer=11, fraction=2)
    private BigDecimal valueDistrictM2;
}
