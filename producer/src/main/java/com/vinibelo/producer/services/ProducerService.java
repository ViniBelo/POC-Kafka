package com.vinibelo.producer.services;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class ProducerService {
    private KafkaTemplate<String, String> kafkaTemplate;

    public void SendMessage(String message) {
        for (var i = 0; i < 25_000; i++) {
            var record = new ProducerRecord<>(
                    "Test_topic",
                    "cliente" + i,
            message + ": " + i);
            kafkaTemplate.send(record);
        }

        for (var i = 0; i < 25_000; i++) {
            var record = new ProducerRecord<>(
                    "Topic_test",
                    "cliente" + i,
                    message + ": " + i);
            kafkaTemplate.send(record);
        }
    }
}
