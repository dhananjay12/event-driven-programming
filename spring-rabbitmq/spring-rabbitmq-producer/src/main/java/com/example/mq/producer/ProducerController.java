package com.example.mq.producer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@Autowired
	Producer producer;

	@PostMapping(path = "simple")
	public ResponseEntity<?> postSimpleString(@RequestBody String msg) {

		producer.produceMsg(msg);
		return ResponseEntity.accepted().build();
	}
	
	@PostMapping(path = "simple/build")
	public ResponseEntity<?> postSimpleBuildString(@RequestBody String msg) {
		String systemErrorLog = "2017-10-10 10:57:51.10 ERROR in Error message";
		Message sysErrMsg = MessageBuilder.withBody(systemErrorLog.getBytes())
											.setHeader("some-header", "header value")
											.build();
		producer.sendMessageObject(sysErrMsg);
		return ResponseEntity.accepted().build();
	}

	@PostMapping(path = "object")
	public ResponseEntity<?> postCustomObject(@RequestBody Department dept) {
		
		producer.sendCustomObject(dept);
		return ResponseEntity.accepted().build();
		
	}

}
