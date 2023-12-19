package com.picpay.adapter.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.picpay.kafka.events.ValidateCpfDTO;
import com.picpay.ports.in.InsertCustomerInputPort;
import com.picpay.ports.in.ValidateAndPublishCpfInputPort;
import com.picpay.ports.in.ValidateCpfInputPort;
import com.picpay.usecase.UpdateValidCpfUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class CpfValidationReturnConsumer {

    private final ValidateCpfInputPort validateCpfInputPort;
    public void validate(ValidateCpfDTO cpf){
        validateCpfInputPort.validate(cpf.getCpf(), cpf.isValidate());
    }
    @Bean
    public Consumer<ValidateCpfDTO> validateCPF(){
        return this::validate;
    }
}

