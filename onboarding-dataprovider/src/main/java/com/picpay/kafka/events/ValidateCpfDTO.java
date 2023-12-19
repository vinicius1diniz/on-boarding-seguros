package com.picpay.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ValidateCpfDTO {
    private String cpf;
    private boolean validate;
}
