package ru.raccoon.hibernatelayerdao.service;

import org.springframework.stereotype.Service;
import ru.raccoon.hibernatelayerdao.model.Person;
import ru.raccoon.hibernatelayerdao.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrepareResponseService {

    PersonRepository personRepository;

    public PrepareResponseService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> prepareResponse(String city) {

        return personRepository.getPersonsByCity(city);
    }
}
