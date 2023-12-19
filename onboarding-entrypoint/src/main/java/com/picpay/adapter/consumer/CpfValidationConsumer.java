package com.picpay.adapter.consumer;

import com.picpay.ports.in.ValidateAndPublishCpfInputPort;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class CpfValidationConsumer {
    private final ValidateAndPublishCpfInputPort validateAndPublishCpfInputPort;
    public void receive(String cpf){
        System.out.println("Entrou no consumer1");
        validateAndPublishCpfInputPort.validateAndPublish(cpf);
    }
    @Bean
    public Consumer<String> receiveCPF(){
        return this::receive;
    }
}
