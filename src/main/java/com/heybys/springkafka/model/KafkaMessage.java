package com.heybys.springkafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KafkaMessage {

	@Getter
	private String message;

	public KafkaMessage(String message) {
		this.message = message;
	}
}
