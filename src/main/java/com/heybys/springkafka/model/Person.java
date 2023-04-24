package com.heybys.springkafka.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Person {

	@Getter
	private String name;

	@Getter
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}
