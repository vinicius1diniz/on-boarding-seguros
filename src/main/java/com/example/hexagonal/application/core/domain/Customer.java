package com.example.hexagonal.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
 private String name;

 private Adress adress;
 private String cpf;
 private Boolean isValidCpf;
 private String zipCode;

}

