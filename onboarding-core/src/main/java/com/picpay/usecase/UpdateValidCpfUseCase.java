package com.picpay.usecase;

import com.picpay.exceptions.CpfNotFoundException;
import com.picpay.ports.in.ValidateCpfInputPort;
import com.picpay.ports.out.FIndCustomerByCpfOutputPort;
import com.picpay.ports.out.UpdateCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateValidCpfUseCase implements ValidateCpfInputPort {
    private final UpdateCpfOutputPort validateCpfOutputPort;
    private final FIndCustomerByCpfOutputPort fIndCustomerByCpfOutputPort;

    @Override
    public void validate(String cpf, boolean status){
        var customer = fIndCustomerByCpfOutputPort.find(cpf).
                orElseThrow(() -> new CpfNotFoundException("Invalid CPF"));
        customer.setIsValidCpf(status);
        validateCpfOutputPort.updateValidCpf(customer);
    }
}
