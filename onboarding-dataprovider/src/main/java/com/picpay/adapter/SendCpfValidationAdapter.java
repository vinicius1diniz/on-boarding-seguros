package com.picpay.adapter;

import com.picpay.ports.out.SendCpfForValidationOutputPort;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public boolean sendValidation(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        HashMap<String, Object> kafkaObject = new HashMap<>();
        boolean status = true;
        kafkaObject.put("cpf", cpf);
        kafkaObject.put("status", status);
        kafkaTemplate.send("tp-cpf-validation", String.valueOf(kafkaObject));
        return status;
        }
}
