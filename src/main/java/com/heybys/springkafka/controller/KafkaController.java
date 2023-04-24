package com.heybys.springkafka.controller;

import com.heybys.springkafka.model.KafkaMessage;
import com.heybys.springkafka.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class KafkaController {

	private final KafkaProducer kafkaProducer;

	@PostMapping("/kafka/message")
	public ResponseEntity<String> sendMessage(@RequestBody KafkaMessage kafkaMessage) {

		kafkaProducer.sendMessage(kafkaMessage.getMessage());

		return ResponseEntity.ok().build();
	}
}
