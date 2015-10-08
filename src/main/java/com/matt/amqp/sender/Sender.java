package com.matt.amqp.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired // from SenderConfig
	RabbitTemplate template;
	
	public void send(String exchangeName, String routingKey, String message) {
		template.convertAndSend(exchangeName, routingKey, message);
	}
}
