package ru.raccoon.hibernatelayerdao.service;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.raccoon.hibernatelayerdao.model.Person;
import ru.raccoon.hibernatelayerdao.repository.CustomizedPersonsCrudRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PrepareResponseService {

    private final CustomizedPersonsCrudRepository personRepository;

    public PrepareResponseService(CustomizedPersonsCrudRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Secured("ROLE_READ")
    public List<Person> prepareResponseByCity(String city) {
        return personRepository.findByCityOfLivingContainingIgnoreCase(city);
    }

    @RolesAllowed("WRITE")
    public List<Person> prepareResponseByAge(int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    public List<Optional<Person>> prepareResponseByNameAndSurname(String name, String surname) {
        return personRepository.getPersonsUsingNameAndSurname(name, surname);
    }

    public List<Person> prepareResponseBySurname(String surname) {
        if (surname.equalsIgnoreCase(getSecurityContextUsername())) {
            return personRepository.findBySurnameContainingIgnoreCase(surname);
        }
        return Collections.emptyList();
    }

    private String getSecurityContextUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return authentication.getName();
    }
}
