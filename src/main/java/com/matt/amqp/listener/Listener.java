package com.matt.amqp.listener;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.matt.amqp.config.EventHandler;

@Component
public class Listener {

	private static boolean started = false;
	
	@Autowired
	Environment environment;
	
	@Autowired // from ListenerConfig
	SimpleMessageListenerContainer container;
	
	@Autowired // from ListenerConfig
	EventHandler eventHandler;
	
	public void start() {
		if(!started) {
			started = true;
			System.out.println("Listener starting ...");
			System.out.println("***** environment.getProperty(\"SPRING_RABBITMQ_ADDRESSES\"): " + environment.getProperty("SPRING_RABBITMQ_ADDRESSES"));
			container.start();
		}
	}
	
	public void stop() {
		if(started) {
			started = false;
			System.out.println("... Listener stopping.");
			container.stop();
		}
	}
}
