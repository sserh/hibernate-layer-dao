package ru.raccoon.hibernatelayerdao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.raccoon.hibernatelayerdao.model.Person;
import ru.raccoon.hibernatelayerdao.service.PrepareResponseService;

import java.util.List;
import java.util.Optional;

@RestController
public class QueryToPersonsController {

    private final PrepareResponseService prepareResponseService;

    public QueryToPersonsController(PrepareResponseService prepareResponseService) {
        this.prepareResponseService = prepareResponseService;
    }

    @GetMapping("/persons/by-city")
    private List<Person> getPersonsByName(@RequestParam String city) {
        return prepareResponseService.prepareResponseByCity(city);
    }

    @GetMapping("/persons/by-age")
    private List<Person> getPersonsByName(@RequestParam int age) {
        return prepareResponseService.prepareResponseByAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    private List<Optional<Person>> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return prepareResponseService.prepareResponseByNameAndSurname(name, surname);
    }
}
