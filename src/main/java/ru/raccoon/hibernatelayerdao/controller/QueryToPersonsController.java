package ru.raccoon.hibernatelayerdao.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Secured("ROLE_READ")
    @GetMapping("persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return prepareResponseService.prepareResponseByCity(city);
    }

    @RolesAllowed("WRITE")
    @GetMapping("persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return prepareResponseService.prepareResponseByAge(age);
    }

    @PostAuthorize("#surname.equalsIgnoreCase(authentication.principal.username)")
    @GetMapping("persons/by-surname")
    public List<Person> getPersonsBySurname(@RequestParam String surname) {
        return prepareResponseService.prepareResponseBySurname(surname);
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("persons/by-name-surname")
    public List<Optional<Person>> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return prepareResponseService.prepareResponseByNameAndSurname(name, surname);
    }
}
