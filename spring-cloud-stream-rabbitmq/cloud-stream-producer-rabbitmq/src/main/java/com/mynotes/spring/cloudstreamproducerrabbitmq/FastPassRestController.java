package com.mynotes.spring.cloudstreamproducerrabbitmq;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastPassRestController {

	@Autowired
	TollSource tollSource;

	@PostMapping("/toll")
	public String publishMessage(@RequestBody String payload) {
		System.out.println(payload);
		Random random = new Random();
		tollSource.standardpasstoll()
				.send(MessageBuilder.withPayload(payload).setHeader("speed", random.nextInt(8) * 10).build());
		return "success";
	}
}
