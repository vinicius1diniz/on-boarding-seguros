package com.picpay.ports.out;

import com.picpay.domain.Customer;

public interface UpdateCpfOutputPort {
    void updateValidCpf(Customer customer);
}
