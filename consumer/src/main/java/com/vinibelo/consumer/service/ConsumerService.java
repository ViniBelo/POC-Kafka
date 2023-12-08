package com.vinibelo.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RetryableTopic(attempts = "2", retryTopicSuffix = "retry-test-topic", dltTopicSuffix = "my-dtl-topic")
    @KafkaListener(topics = "Test_topic")
    public void listenTestTopic(String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("Received Message 1° topic: " + message);
        System.out.println(partition);
        System.out.println("................................................");
    }

    @KafkaListener(topics = "Topic_test")
    public void listenTopicTest(String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("Received Message 2° topic: " + message);
        System.out.println(partition);
        System.out.println("................................................");
    }

}
