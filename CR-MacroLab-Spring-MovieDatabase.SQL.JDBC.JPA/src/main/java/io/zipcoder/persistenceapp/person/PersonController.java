package io.zipcoder.persistenceapp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private JdbcPersonServiceImpl personService;

    public PersonController() {
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public List<Person> getAllPeople(){
        return personService.findAll();
    }

    @RequestMapping(value = "/people/{id}/{firstName}/{lastname}/{mobile}/{birthday}/{homeId}", method = RequestMethod.POST)
    public Person createPerson(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastname, @PathVariable String mobile, @PathVariable String birthday, @PathVariable Short homeId) {
        return personService.createPerson(id, firstName, lastname, mobile, birthday, homeId);
    }

    @RequestMapping(value = "/people/{id}/{firstName}/{lastname}/{mobile}/{birthday}/{homeId}", method = RequestMethod.PUT)
    public Person updatePerson(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastname, @PathVariable String mobile, @PathVariable String birthday, @PathVariable Short homeId) {
        return personService.updatePerson(id, firstName, lastname, mobile, birthday, homeId);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @RequestMapping(value = "/people/{lastName}", method = RequestMethod.GET)
    public Person getPersonByLastname(@PathVariable String lastName){
        return personService.getPerson(lastName);
    }

    @RequestMapping(value = "/people/{mobile}", method = RequestMethod.GET)
    public Person getReverseLookup(@PathVariable String mobile){
        return personService.getReverseLookup(mobile);
    }

    @RequestMapping(value = "/people/firstname/stats/{firstName}", method = RequestMethod.GET)
    public int getFirstNameStats(@PathVariable String firstName){
        return personService.getFirstnameStats(firstName);
    }
}
