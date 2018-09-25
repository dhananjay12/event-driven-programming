package com.mynotes.spring.cloudstreamproducerrabbitmq;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(TollSource.class)
public class TollPublishers {
	
	Random random=new Random();
	
//	@Bean
//	@InboundChannelAdapter(channel="standardpasstoll", poller=@Poller(fixedDelay="2000"))
//	public MessageSource<Toll> sendTollChargeWithHeaders() {
//		return ()-> MessageBuilder.withPayload(new Toll("21", "111", "2018-09-25T11:40:00"))
//				.setHeader("speed", random.nextInt(8)*10).build();
//	}
	
	@Bean
	@InboundChannelAdapter(channel="premiumpasstoll", poller=@Poller(fixedDelay="2000"))
	public MessageSource<Toll> sendTollCharge() {
		return ()-> MessageBuilder.withPayload(new Toll("21", "111", "2018-09-25T11:40:00")).build();
	}
	
	class Toll{
		public String stationId;
		public String customerId;
		public String timestamp;
		public Toll(String stationId, String customerId, String timestamp) {
			this.stationId = stationId;
			this.customerId = customerId;
			this.timestamp = timestamp;
		}
		
	}

}

