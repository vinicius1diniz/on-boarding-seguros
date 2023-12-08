package com.picpay.adapter.consumer;

import com.picpay.ports.in.ValidateAndPublishCpfInputPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class CpfValidationConsumer {
    private final ValidateAndPublishCpfInputPort validateAndPublishCpfInputPort;
    public void receive(String cpf){
        validateAndPublishCpfInputPort.validateAndPublish(cpf);
    }
    @Bean
    public Consumer<String> receiveCPF(){
        return this::receive;
    }
}
