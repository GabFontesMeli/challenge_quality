package com.example.challenge_quality.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    private Integer id;

    @NotBlank(message = "O bairro não pode estar vazio.")
    @Size(min = 3, max = 45, message = "O comprimento do nome do bairro deve ter entre 3 e 45 caracteres.")
    private String name;

    @NotNull(message = "O valor do metro quadrado do bairro não pode estar vazio.")
    @Digits(integer=11, fraction=2)
    private BigDecimal valueDistrictM2;
}
