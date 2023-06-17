package com.berkanaslan.springnativemultipledatasource.controller;

import com.berkanaslan.springnativemultipledatasource.model.Person;
import com.berkanaslan.springnativemultipledatasource.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(PersonController.PATH)
@RequiredArgsConstructor
public class PersonController {
    protected static final String PATH  = "/person";

    private final PersonRepository personRepository;

    @GetMapping(path = "{id}")
    public Person findById(@PathVariable(name = "id") UUID id) {
        return personRepository.findById(id).orElse(null);
    }
}
