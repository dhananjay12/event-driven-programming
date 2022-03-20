package com.mynotes.spring.events.service;

import com.mynotes.spring.events.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
@Slf4j
public class PersonService {

    private static List<Person> allPersons= new ArrayList<>();

    private StreamBridge streamBridge;

    public PersonService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }



    public void create(Person person){
        if(!findPerson(person.getName()).isPresent()){
            log.info("Create=>"+ person);
            allPersons.add(person);
            emitCreatedEvent(person);
        }else{
         throw new ValidationException(person.getName()+" already exist");
        }
    }

    public void delete(String name){
        log.info("Delete=>"+name);
        Optional<Person> person= findPerson(name);
        if(person.isPresent()){
            allPersons.remove(person.get());
            emitDeleteEvent(name);
        }
    }

    private Optional<Person> findPerson(String name) {
        return allPersons.stream().filter(person -> person.getName().equals(name)).findFirst();
    }

    private void emitCreatedEvent(Person person) {
        streamBridge.send("createPerson-out-0", person);
    }

    private void emitDeleteEvent(String name) {
        streamBridge.send("deletePerson-out-0",name);
    }
}
