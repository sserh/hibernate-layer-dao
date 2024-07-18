package ru.raccoon.hibernatelayerdao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
