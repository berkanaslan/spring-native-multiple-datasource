package com.berkanaslan.springnativemultipledatasource;

import com.berkanaslan.springnativemultipledatasource.model.person.Person;
import com.berkanaslan.springnativemultipledatasource.repository.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initializer implements ApplicationListener<ApplicationReadyEvent> {

    private final PersonRepository personRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        personRepository.save(new Person("Berkan", Person.Gender.MALE));
    }
}
