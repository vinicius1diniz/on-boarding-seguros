package com.picpay.ports.out;

import com.picpay.domain.Customer;

import java.util.Optional;

public interface FIndCustomerByCpfOutputPort {
    Optional<Customer> find(String cpf);
}
