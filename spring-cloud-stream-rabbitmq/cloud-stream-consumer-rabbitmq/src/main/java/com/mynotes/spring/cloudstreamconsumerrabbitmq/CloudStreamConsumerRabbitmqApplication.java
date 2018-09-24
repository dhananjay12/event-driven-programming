package com.mynotes.spring.cloudstreamconsumerrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(ConsumerChannels.class)
@SpringBootApplication
public class CloudStreamConsumerRabbitmqApplication {
	
	@Bean
    IntegrationFlow integrationFlow(ConsumerChannels c) {
        return IntegrationFlows
                .from(c.producer())
                .transform(Transformers.objectToString())
                .handle(String.class, (payload, headers) -> {
                	System.out.println("new message: "+ payload);
                    return null;
                })
                .get();
    }

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamConsumerRabbitmqApplication.class, args);
	}
}

interface ConsumerChannels {

    @Input
    SubscribableChannel producer();
}