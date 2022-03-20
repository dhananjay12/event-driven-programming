package com.mynotes.spring.events.bindings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CreatePersonBinding {

    @Output("createPerson")
    MessageChannel createPerson();
}
