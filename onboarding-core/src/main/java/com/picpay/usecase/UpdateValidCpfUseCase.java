package com.picpay.usecase;

import com.picpay.ports.in.ValidateCpfInputPort;
import com.picpay.ports.out.ValidateCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ValidateCpfUseCase implements ValidateCpfInputPort {
    private final ValidateCpfOutputPort validateCpfOutputPort;

    @Override
    public void validate(String cpf, boolean status){
        validateCpfOutputPort.updateValidCpf(cpf, status);
    }
}
