package org.j2os.classFinal.service;

import org.j2os.classFinal.domain.Person;
import org.j2os.classFinal.repository.PersonClassicRepository;
import org.j2os.classFinal.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonClassicRepository personClassicRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person save(Person person) {
        return personClassicRepository.save(person);
    }

    public Person findByName(Person person)
    {
        return personRepository.findByName(person.getName());
    }

//    public List<Person> findById(Person person)
//    {
//        return personRepository.findById(person.getId());
//    }
}
