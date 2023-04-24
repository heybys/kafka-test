package com.heybys.springkafka.service;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("heybys-topic", message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.println("Sent message=[" + message +
						"] with offset=[" + result.getRecordMetadata() + "]");
			} else {
				System.out.println("Unable to send message=[" +
						message + "] due to : " + ex.getMessage());
			}
		});
	}
}
