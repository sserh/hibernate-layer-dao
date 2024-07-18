package ru.raccoon.hibernatelayerdao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PersonPrimaryKey.class)
public class Person {

    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;

    private String phoneNumber;
    private String cityOfLiving;

    public static Optional<Person> returnOptional(Person person) {
        return Optional.ofNullable(person);
    }

}
