package com.picpay.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer<T> {
    private final ObjectMapper objectMapper;
    private final StreamBridge streamBridge;

    public void publish(T message, String binding){

        String jsonMessage = null;
        try {
            jsonMessage = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Message<String> event = MessageBuilder
                .withPayload(jsonMessage)
                .build();
        streamBridge.send(binding, event);
    }
}
