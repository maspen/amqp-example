package com.matt.amqp.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
	@Value("${queueName}")
	String queueName;
	
	private static SimpleMessageListenerContainer container = null;
	private static MessageListenerAdapter adapter = null;
	
	@Autowired //  //from Config
	ConnectionFactory connectionFactory;
	
	@Autowired // from EventHandler
	EventHandler eventHandler;
	
	@Bean
	SimpleMessageListenerContainer container() {
		if(null == container) {
			container = new SimpleMessageListenerContainer(connectionFactory);
			container.setQueueNames(queueName);
			container.setMessageListener(adapter());
		}
		return container;
	}
	
	@Bean
	MessageListenerAdapter adapter() {
		if(null == adapter) {
			adapter = new MessageListenerAdapter(eventHandler);
		}
		return adapter;
	}
}
