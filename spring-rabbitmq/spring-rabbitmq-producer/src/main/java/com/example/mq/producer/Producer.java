package com.example.mq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingkey;
	
	@Value("${jsa.rabbitmq.object.exchange}")
	private String objectExchange;
	
	@Value("${jsa.rabbitmq.object.routingkey}")
	private String objectRoutingkey;
	
	public void produceMsg(String msg){
		amqpTemplate.convertAndSend(exchange, routingkey, msg);
	}
	
	public void sendCustomObject(Department dept){
		amqpTemplate.convertAndSend(objectExchange, objectRoutingkey, dept);
	}
	
	public void sendMessageObject(Message msg){
		amqpTemplate.send(exchange, routingkey,msg);
	}

}
