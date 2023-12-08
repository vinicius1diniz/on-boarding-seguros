package com.picpay.ports.out;

public interface PublishCpfValidationOutPutPort {
    void publish(String cpf, boolean validate);
}
