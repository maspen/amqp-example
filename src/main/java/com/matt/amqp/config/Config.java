package com.matt.amqp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Config {
	// NOTE: fields populated via @Value cannot be static
	@Value("${host}")
	String host;
	@Value("${queueName}")
	String queueName;
	@Value("${exchangeName}")
	String exchangeName;
	@Value("${routingKey}")
	String routingKey;

	//private static ConnectionFactory connectioFactory = null;
	//private static RabbitAdmin rabbitAdmin = null;
	//private static Queue queue = null;
	//private static TopicExchange topicExchange = null;
	
//	@Bean
//	ConnectionFactory connectionFactory() {
//		if(null == connectioFactory) {
//			connectioFactory = new CachingConnectionFactory(host);
//		}
//		return connectioFactory;
//	}
	
//	@Bean
//	RabbitAdmin rabbitAdmin() {
//		if(null == rabbitAdmin) {
//			rabbitAdmin = new RabbitAdmin(connectionFactory());
//			rabbitAdmin.declareQueue(queue());
//			rabbitAdmin.declareExchange(topicExchange());
//			rabbitAdmin.declareBinding(BindingBuilder.bind(queue()).to(topicExchange()).with(routingKey));
//		}
//		return rabbitAdmin;
//	}
	
	@Bean
	Queue queue() {
//		if(null == queue) {
//			queue = new Queue(queueName);
//		}
//		return queue;
		return new Queue(queueName);
	}
	
	@Bean
	TopicExchange topicExchange() {
//		if(null == topicExchange) {
//			topicExchange = new TopicExchange(exchangeName);
//		}
//		return topicExchange;
		return new TopicExchange(exchangeName);
	}
}
