package io.zipcoder.persistenceapp.person;

import java.util.List;


public interface PersonService {

    List<Person> findAll();
    Person createPerson(Long id, String firstName, String lastName, String mobile, String birthdate, Short homeId);
    Person updatePerson(Long id, String firstName, String lastName, String mobile, String birthdate, Short homeId);
    Person getPerson(Long id);
    Person getPerson(String lastname);
    Person getReverseLookup(String mobile);
    int getFirstnameStats(String firstname);
}
