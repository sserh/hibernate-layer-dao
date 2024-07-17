package ru.raccoon.hibernatelayerdao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import ru.raccoon.hibernatelayerdao.model.Person;

import java.util.List;
import java.util.Locale;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Person> getPersonsByCity(String city) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class);

        Predicate predicate = cb.equal(cb.lower(root.get("cityOfLiving")), city.toLowerCase(Locale.ROOT));

        cq.select(root).where(predicate);

        Query q = em.createQuery(cq);

        return q.getResultList();
    }
}
