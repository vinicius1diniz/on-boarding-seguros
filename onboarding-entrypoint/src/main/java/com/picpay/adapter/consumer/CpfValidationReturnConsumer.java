//package com.picpay.adapter.consumer;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.picpay.ports.in.InsertCustomerInputPort;
//import com.picpay.ports.in.ValidateCpfInputPort;
//import lombok.RequiredArgsConstructor;
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Properties;
//@Service
//public class CpfValidationReturnConsumer {
//    @Autowired
//    private static ValidateCpfInputPort validateCpfInputPort;
//    static ObjectMapper objectMapper = new ObjectMapper();
//    public static void main(String[] args) throws JsonProcessingException {
//        Properties properties = new Properties();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "cpf-validation-group");
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer .class.getName());
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//
//        Consumer<String, String> consumer = new KafkaConsumer<>(properties);
//        consumer.subscribe(Collections.singletonList("tp-cpf-validation-return"));
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//
//            for (var record : records) {
//                HashMap<String, Object> hashMap = objectMapper.readValue(record.value(), new TypeReference<HashMap<String, Object>>() {});
//                System.out.println("chegou");
//                System.out.println(hashMap.get("status"));
//                validateCpfInputPort.validate((String) hashMap.get("cpf"), (Boolean) hashMap.get("status"));
//            }
//        }
//    }
//}
//
