package com.matt.amqp.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {
	
	private static RabbitTemplate template = null;
	
	@Autowired // from Config
	ConnectionFactory connectionFactory;
	
	@Bean
	RabbitTemplate template() {
		if(null == template) {
			template = new RabbitTemplate(connectionFactory);
		}
		return template;
	}
}
