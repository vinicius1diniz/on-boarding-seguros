package com.picpay.ports.in;

import com.picpay.domain.Customer;

public interface ValidateCpfInputPort {
    void validate(String cpf, boolean status);
}
