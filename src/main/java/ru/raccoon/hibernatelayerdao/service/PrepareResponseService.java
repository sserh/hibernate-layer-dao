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

    public List<String> prepareResponse(String city) {

        List<String> stringList = new ArrayList<>();
        stringList.add("В городе " + city + " проживают: ");
        List<Person> personList = personRepository.getPersonsByCity(city);

        for (Person person : personList) {
            stringList.add(person.getName() + " " + person.getSurname());
        }

        return stringList;
    }
}
