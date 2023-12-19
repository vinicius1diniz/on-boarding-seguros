package com.picpay.usecase;

import com.picpay.ports.in.ValidateAndPublishCpfInputPort;
import com.picpay.ports.out.PublishCpfValidationOutPutPort;
import com.picpay.utils.ValidateCpfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateAndPublishCpfUseCase implements ValidateAndPublishCpfInputPort {

    private final PublishCpfValidationOutPutPort publishCpfValidationOutPutPort;
    private final UpdateValidCpfUseCase updateValidCpfUseCase;

    @Override
    public void validateAndPublish(String cpf) {
        boolean status = ValidateCpfUtils.validaCPF(cpf);
        publishCpfValidationOutPutPort.publish(cpf, status);
        updateValidCpfUseCase.validate(cpf,status);

    }
}
