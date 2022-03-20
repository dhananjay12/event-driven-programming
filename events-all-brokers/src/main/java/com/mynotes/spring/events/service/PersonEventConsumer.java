package com.mynotes.spring.events.service;

import com.mynotes.spring.events.model.Person;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PersonEventConsumer {

    @Bean
    public Consumer<Person> createPersonConsumer() {
        return value -> {
            System.out.println("Received Create Person: " + value.toString());
        };
    }

    @Bean
    public Consumer<String> deletePersonConsumer() {
        return value -> {
            System.out.println("Received Delete Person: " + value);
        };
    }
}
