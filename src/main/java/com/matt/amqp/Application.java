package com.matt.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.JobExecutionExitCodeGenerator;
import org.springframework.context.ConfigurableApplicationContext;

import com.matt.amqp.listener.Listener;
import com.matt.amqp.sender.Sender;

@SpringBootApplication
public class Application implements CommandLineRunner {
	static String exchangeName = "new-exchange";
	static String routingKey = "foo.bar";
	
	private static ConfigurableApplicationContext context;
	
	@Autowired
	Listener listener;
	
	@Autowired
	Sender sender;
	
    public static void main(String[] args) {
    	context = SpringApplication.run(Application.class, args);
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
