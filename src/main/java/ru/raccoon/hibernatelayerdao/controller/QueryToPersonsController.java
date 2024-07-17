package ru.raccoon.hibernatelayerdao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.raccoon.hibernatelayerdao.service.PrepareResponseService;

import java.util.List;

@RestController
public class QueryToPersonsController {

    private final PrepareResponseService prepareResponseService;

    public QueryToPersonsController(PrepareResponseService prepareResponseService) {
        this.prepareResponseService = prepareResponseService;
    }

    @GetMapping("/persons/by-city")
    private List<String> getPersonsByCity(@RequestParam String city) {
        return prepareResponseService.prepareResponse(city);
    }
}
