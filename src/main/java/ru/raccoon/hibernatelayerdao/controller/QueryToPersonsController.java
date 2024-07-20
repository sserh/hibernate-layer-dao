package ru.raccoon.hibernatelayerdao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.raccoon.hibernatelayerdao.model.Person;
import ru.raccoon.hibernatelayerdao.service.PrepareResponseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class QueryToPersonsController {

    private final PrepareResponseService prepareResponseService;

    public QueryToPersonsController(PrepareResponseService prepareResponseService) {
        this.prepareResponseService = prepareResponseService;
    }

    @GetMapping("persons/by-city")
    private List<Person> getPersonsByCity(@RequestParam String city) {
        return prepareResponseService.prepareResponseByCity(city);
    }

    @GetMapping("persons/by-age")
    private List<Person> getPersonsByAge(@RequestParam int age) {
        return prepareResponseService.prepareResponseByAge(age);
    }

    @GetMapping("persons/by-name-surname")
    private List<Optional<Person>> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return prepareResponseService.prepareResponseByNameAndSurname(name, surname);
    }

    @GetMapping("persons/by-surname")
    private List<Person> getPersonsBySurname(@RequestParam String surname) {
        return prepareResponseService.prepareResponseBySurname(surname);
    }
}
