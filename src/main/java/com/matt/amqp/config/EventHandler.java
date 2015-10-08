package com.matt.amqp.config;

import org.springframework.context.annotation.Configuration;

// handles events for the listener
@Configuration
public class EventHandler {
	
	public void handleMessage(String foo) {
		System.out.println("EventHandler says: " + foo);
	}
}
