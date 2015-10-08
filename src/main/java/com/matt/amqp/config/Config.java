package com.matt.amqp.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	static String host = "localhost";
	static String queueName = "test-queue";
	static String exchangeName = "new-exchange";
	static String routingKey = "foo.*";
	
	private static ConnectionFactory connectioFactory = null;
	private static RabbitAdmin rabbitAdmin = null;
	private static Queue queue = null;
	private static TopicExchange topicExchange = null;
	
	@Bean
	ConnectionFactory connectionFactory() {
		if(null == connectioFactory) {
			connectioFactory = new CachingConnectionFactory(host);
		}
		return connectioFactory;
	}
	
	@Bean
	RabbitAdmin rabbitAdmin() {
		if(null == rabbitAdmin) {
			rabbitAdmin = new RabbitAdmin(connectionFactory());
			rabbitAdmin.declareQueue(queue());
			rabbitAdmin.declareExchange(topicExchange());
			rabbitAdmin.declareBinding(BindingBuilder.bind(queue()).to(topicExchange()).with(routingKey));
		}
		return rabbitAdmin;
	}
	
	@Bean
	Queue queue() {
		if(null == queue) {
			queue = new Queue(queueName);
		}
		return queue;
	}
	
	@Bean
	TopicExchange topicExchange() {
		if(null == topicExchange) {
			topicExchange = new TopicExchange(exchangeName);
		}
		return topicExchange;
	}
}