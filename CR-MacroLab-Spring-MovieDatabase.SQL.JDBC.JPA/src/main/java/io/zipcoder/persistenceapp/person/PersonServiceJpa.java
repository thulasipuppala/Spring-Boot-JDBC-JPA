package io.zipcoder.persistenceapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PersonServiceJpa implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person createPerson(Long id, String firstName, String lastName, String mobile, String birthdate, Short homeId) {
        return personRepository.save(new Person(id,firstName,lastName,mobile,birthdate,homeId));
    }

    @Override
    public Person updatePerson(Long id, String firstName, String lastName, String mobile, String birthdate, Short homeId) {
        return personRepository.save(new Person(id,firstName,lastName,mobile,birthdate,homeId));
    }

    @Override
    public Person getPerson(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public Person getPerson(String lastname) {
        List<Person> ppl = findAll();
        for (Person p : ppl) {
            if (p.getLastName().equals(lastname))
                return p;
        }
        return null;
    }

    @Override
    public Person getReverseLookup(String mobile) {
        List<Person> ppl = findAll();
        for (Person p : ppl) {
            if (p.getMobile().equals(mobile))
                return p;
        }
        return null;
    }

    @Override
    public int getFirstnameStats(String firstname) {
        List<Person> ppl = findAll();
        int count = 0;
        for (Person p : ppl) {
            if (p.getMobile().equals(firstname))
               count++;
        }
        return count;
    }
}
