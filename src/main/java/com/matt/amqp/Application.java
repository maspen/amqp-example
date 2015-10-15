package com.matt.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matt.amqp.listener.Listener;
import com.matt.amqp.sender.Sender;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Value("${exchangeName}")
	String exchangeName;
	@Value("${routingKey}")
	String routingKey;
	
	@Autowired
	Listener listener;
	
	@Autowired
	Sender sender;
	
    public static void main(String[] args) {
    	//context = SpringApplication.run(Application.class, args);
    	// print out value of "SPRING_RABBITMQ_ADDRESSES" if any:
    	System.out.println("***** in main, 'System.getenv(\"SPRING_RABBITMQ_ADDRESSES\")': " + System.getenv("SPRING_RABBITMQ_ADDRESSES"));
    	
    	SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		listener.start();

		sender.send(exchangeName, routingKey, "Hello world - FROM Sender ");
		
		Thread.sleep(1000);

		listener.stop();
		
		//SpringApplication.exit(context, new JobExecutionExitCodeGenerator());
	}
}
