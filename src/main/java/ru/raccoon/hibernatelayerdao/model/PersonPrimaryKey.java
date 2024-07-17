package ru.raccoon.hibernatelayerdao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonPrimaryKey implements Serializable {

    private String name;
    private String surname;
    private int age;
}
