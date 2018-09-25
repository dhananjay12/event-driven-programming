package com.mynotes.spring.cloudstreamconsumerrabbitmq;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

//@EnableBinding(Sink.class)
public class TollIntake {
	
	@StreamListener(Sink.INPUT)
	public void log(String msg) {
		System.out.println(msg);
	}

}
