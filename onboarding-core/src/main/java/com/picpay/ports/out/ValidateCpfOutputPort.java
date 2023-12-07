package com.picpay.ports.out;

public interface ValidateCpfOutputPort {
    void updateValidCpf(String cpf, boolean status);
}
