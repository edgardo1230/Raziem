package com.raziem.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Sender.class);
	private final RabbitTemplate rabbitTemplate;

	public Sender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.debug("Sending message...");
		rabbitTemplate.convertAndSend(AmqpConf.topicExchangeName, AmqpConf.routingKey, "Hello World!");
	}
}