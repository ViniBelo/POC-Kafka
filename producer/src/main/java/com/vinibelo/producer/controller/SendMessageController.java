package com.vinibelo.producer.controller;

import com.vinibelo.producer.services.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("teste")
public class SendMessageController {
    private ProducerService producerService;

    @GetMapping
    public ResponseEntity<CompletableFuture<SendResult<String, String>>> sendMessage(@RequestBody String message) {
        producerService.SendMessage(message);
        return ResponseEntity.ok().build();
    }
}
