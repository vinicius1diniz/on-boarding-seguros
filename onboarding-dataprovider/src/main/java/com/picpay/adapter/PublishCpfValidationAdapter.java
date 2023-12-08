package com.picpay.adapter;

import com.picpay.kafka.KafkaProducer;
import com.picpay.kafka.events.ValidateCpfDTO;
import com.picpay.ports.out.PublishCpfValidationOutPutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@RequiredArgsConstructor
public class PublishCpfValidationAdapter implements PublishCpfValidationOutPutPort {
    private final KafkaProducer<ValidateCpfDTO> producer;
    @Override
    public void publish(String cpf, boolean validate) {
        ValidateCpfDTO validateCpfDTO =  ValidateCpfDTO.builder().cpf(cpf).validate(validate).build();
        producer.publish(validateCpfDTO, "sendValidation-out-0");
    }
}
