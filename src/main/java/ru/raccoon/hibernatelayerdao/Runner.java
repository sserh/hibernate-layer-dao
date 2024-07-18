package ru.raccoon.hibernatelayerdao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.raccoon.hibernatelayerdao.model.Person;
import ru.raccoon.hibernatelayerdao.model.PersonPrimaryKey;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //код добавления данных в таблицу

/*        Person person_1 = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder()
                        .name("Ivan")
                        .surname("Ivanov")
                        .age(31)
                        .build())
                .phoneNumber("+79538473100")
                .cityOfLiving("Svinsk")
                .build();

        Person person_2 = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder()
                        .name("Egor")
                        .surname("Egorov")
                        .age(19)
                        .build())
                .phoneNumber("+79538479100")
                .cityOfLiving("Svinsk")
                .build();

        Person person_3 = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder()
                        .name("Petr")
                        .surname("Petrov")
                        .age(99)
                        .build())
                .phoneNumber("+79538479900")
                .cityOfLiving("Cemetery")
                .build();

        Person person_4 = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder()
                        .name("Petr")
                        .surname("Petrov")
                        .age(45)
                        .build())
                .phoneNumber("+79538474500")
                .cityOfLiving("SPb")
                .build();

        entityManager.persist(person_1);
        entityManager.persist(person_2);
        entityManager.persist(person_3);*/
    }
}
