package ru.raccoon.hibernatelayerdao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.raccoon.hibernatelayerdao.model.Person;
import ru.raccoon.hibernatelayerdao.model.PersonPrimaryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonsCrudRepository extends CrudRepository<Person, PersonPrimaryKey> {

    List<Person> findByCityOfLivingContainingIgnoreCase(String city);

    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    List<Person> findByNameContainingIgnoreCaseAndSurnameContainingIgnoreCase(String name, String surname);
    default List<Optional<Person>> getPersonsUsingNameAndSurname(String name, String surname) {
        List<Optional<Person>> persons = new ArrayList<>();
        for (Person person : findByNameContainingIgnoreCaseAndSurnameContainingIgnoreCase(name, surname)) {
            persons.add(Optional.of(person));
        }
        return persons;
    }
}
