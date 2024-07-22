package ru.raccoon.hibernatelayerdao.service;

import org.springframework.stereotype.Service;
import ru.raccoon.hibernatelayerdao.model.Person;
import ru.raccoon.hibernatelayerdao.repository.CustomizedPersonsCrudRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrepareResponseService {

    private final CustomizedPersonsCrudRepository personRepository;

    public PrepareResponseService(CustomizedPersonsCrudRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> prepareResponseByCity(String city) {
        return personRepository.findByCityOfLivingContainingIgnoreCase(city);
    }

    public List<Person> prepareResponseByAge(int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public List<Optional<Person>> prepareResponseByNameAndSurname(String name, String surname) {
        return personRepository.getPersonsUsingNameAndSurname(name, surname);
    }

    public List<Person> prepareResponseBySurname(String surname) {
        return personRepository.findBySurnameContainingIgnoreCase(surname);
    }
}
