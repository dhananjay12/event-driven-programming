package com.mynotes.spring.cloudstreamconsumerrabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Processor.class)
public class TollIntakeConditonalHeaders {

	@StreamListener(target = Sink.INPUT, condition = "headers['speed'] > 40")
	public void logFast(String msg) {
		System.out.println("fast" + msg);
	}
	
	@StreamListener(target = Sink.INPUT, condition = "headers['speed'] <= 40")
	public void logSlow(String msg) {
		System.out.println("slow" + msg);
	}

}
