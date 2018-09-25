package com.mynotes.spring.cloudstreamproducerrabbitmq;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(Source.class)
public class TollPublisher {
	
	@InboundChannelAdapter(channel=Source.OUTPUT)
	public String sendTollCharge() {
		return "{station:\"20\",customerId:\"100\",timestamp:\"2018-09-25T11:40:00\"}";
	}

}
