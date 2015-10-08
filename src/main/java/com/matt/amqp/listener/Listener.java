package com.matt.amqp.listener;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matt.amqp.config.EventHandler;

@Component
public class Listener {

	private static boolean started = false;
	
	@Autowired // from ListenerConfig
	SimpleMessageListenerContainer container;
	
	@Autowired // from ListenerConfig
	EventHandler eventHandler;
	
	public void start() {
		if(!started) {
			started = true;
			System.out.println("Listener starting ...");
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
