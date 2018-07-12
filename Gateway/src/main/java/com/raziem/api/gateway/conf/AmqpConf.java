package com.raziem.api.gateway.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConf {

	private static final Logger logger = LoggerFactory.getLogger(AmqpConf.class);
	static final String topicExchangeName = "spring-amqp-exchange";
	static final String queueName = "q1";
	static final String routingKey = "q1";

	

    @Value("${rabbitmq.host}")
    private String host;
    @Value("${rabbitmq.virtual-host}")
    private String vhost;
    @Value("${rabbitmq.username}")
    private String user;
    @Value("${rabbitmq.password}")
    private String password;
    @Value("${rabbitmq.port}")
    private int port;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        System.out.println("rmqhost is " + host);
        factory.setHost(host);
        factory.setVirtualHost(vhost);
        factory.setUsername(user);
        factory.setPassword(password);
        factory.setPort(port);
        return factory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(connectionFactory());
    }
    
    

}
