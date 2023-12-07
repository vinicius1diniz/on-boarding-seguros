//package com.picpay.adapter.consumer;
//
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Properties;
//@Service
//public class CpfValidationConsumer {
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    public void consumeMessages(){
//        Properties properties = new Properties();
//        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "cpf-validation-group");
//        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//
//        Consumer<String, String> consumer = new KafkaConsumer<>(properties);
//        consumer.subscribe(Collections.singletonList("tp-cpf-validation"));
//
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//
//            for (var record : records) {
//                String cpf = record.value();
//                System.out.println(cpf);
//                if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
//                    kafkaTemplate.send("tp-cpf-validation-return", "invalid");
//                }
//                int sum = 0;
//                int[] cpfArray = new int[11];
//                for (int i = 0; i < 11; i++) {
//                    cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
//                }
//                for (int i = 0; i < 9; i++) {
//                    sum += cpfArray[i] * (10 - i);
//                }
//                int firstDigit = 11 - (sum % 11);
//                if (firstDigit > 9) {
//                    firstDigit = 0;
//                }
//                if (firstDigit != cpfArray[9]) {
//                    kafkaTemplate.send("tp-cpf-validation-return", "invalid");
//                }
//                sum = 0;
//                for (int i = 0; i < 10; i++) {
//                    sum += cpfArray[i] * (11 - i);
//                }
//                int secondDigit = 11 - (sum % 11);
//                if (secondDigit > 9) {
//                    secondDigit = 0;
//                }
//                if(secondDigit == cpfArray[10]){
//                    kafkaTemplate.send("tp-cpf-validation-return", "valid");
//                }else{
//                    kafkaTemplate.send("tp-cpf-validation-return", "invalid");
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        CpfValidationConsumer consumer = new CpfValidationConsumer();
//        consumer.consumeMessages();
//    }
//}
