package org.j2os.classFinal.repository;

import org.j2os.classFinal.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonClassicRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }
}
