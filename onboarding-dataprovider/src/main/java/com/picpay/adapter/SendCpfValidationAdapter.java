package com.picpay.adapter;

import com.picpay.kafka.KafkaProducer;
import com.picpay.ports.out.SendCpfForValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    private final KafkaProducer<String> kafkaProducer;
    @Override
    public void sendValidation(String cpf) {
        kafkaProducer.publish(cpf, "sendCPF-out-0");
        }
}
