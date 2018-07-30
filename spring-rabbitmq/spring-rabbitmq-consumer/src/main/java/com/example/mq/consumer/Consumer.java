package com.example.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message: " + msg);
    }
	
	@RabbitListener(queues="${jsa.rabbitmq.object.queue}")
    public void recievedObjectMessage(Department dept) {
        System.out.println("RecievedobjectMessage: " + dept);
    }

}
