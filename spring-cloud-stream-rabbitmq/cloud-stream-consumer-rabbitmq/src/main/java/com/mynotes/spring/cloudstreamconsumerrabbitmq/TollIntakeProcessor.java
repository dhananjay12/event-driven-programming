package com.mynotes.spring.cloudstreamconsumerrabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

//@EnableBinding(Processor.class)
public class TollIntakeProcessor {
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public String log(String msg) {
		System.out.println(msg);
		return msg;
	}

}
