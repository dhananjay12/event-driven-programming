package com.mynotes.spring.events.controller;

import com.mynotes.spring.events.model.Person;
import com.mynotes.spring.events.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ExampleController {

    private final PersonService personService;

    public ExampleController(PersonService personService, StreamBridge streamBridge) {
        this.personService = personService;
    }

    @PostMapping("/person" )
    public void register(@RequestBody Person person) {
        personService.create(person);
    }

    @DeleteMapping("/person/{name}")
    public void delete(@PathVariable String name) {
        personService.delete(name);
    }
}

