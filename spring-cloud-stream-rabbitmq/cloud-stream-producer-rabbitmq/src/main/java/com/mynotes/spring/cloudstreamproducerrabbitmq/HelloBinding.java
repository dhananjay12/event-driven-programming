package com.mynotes.spring.cloudstreamproducerrabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

interface HelloBinding {

    @Output("greetingChannel")
    MessageChannel greeting();

}
