package com.mynotes.spring.cloudstreamproducerrabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface TollSource {
	
	@Output("premiumpasstoll")
	MessageChannel premiumpasstoll();
	
	@Output("standardpasstoll")
	MessageChannel standardpasstoll();

}
