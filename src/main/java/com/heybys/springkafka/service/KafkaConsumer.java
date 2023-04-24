package com.heybys.springkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heybys.springkafka.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

	@KafkaListener(topics = "heybys-topic", groupId = "foo")
	public void listen(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Person person = objectMapper.readValue(message, Person.class);
			log.info("Received message({}) from partition({})", person.toString(), partition);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

	}
}
