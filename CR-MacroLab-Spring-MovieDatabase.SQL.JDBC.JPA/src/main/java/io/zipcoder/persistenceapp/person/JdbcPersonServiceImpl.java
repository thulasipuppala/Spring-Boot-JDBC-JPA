package io.zipcoder.persistenceapp.person;

import io.zipcoder.persistenceapp.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JdbcPersonServiceImpl implements PersonService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        String sql = "SELECT * FROM Person";
        List<Person> people = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Person p = new Person();
            p.setId(Long.parseLong(String.valueOf(row.get("id"))));
            p.setFirstName((String) row.get("first_name"));
            p.setLastName((String) row.get("last_name"));
            p.setMobile((String) row.get("mobile"));
            p.setBirthDate(String.valueOf(row.get("birthday")));
            p.setHomeId(Short.parseShort(String.valueOf(row.get("home_id"))));
            people.add(p);
        }
        return people;
    }

    public Person createPerson(Long id, String firstName, String lastName, String mobile, String birthdate, Short homeId){
    this.jdbcTemplate.update("insert into person (id, first_name, last_name, mobile, birthday, home_id) values (?, ?, ?, ?, ?, ?)",
            new Object[] {id, firstName, lastName, mobile, birthdate, homeId});
    return new Person(id, firstName,lastName, mobile, birthdate, homeId);
    }

    public Person updatePerson(Long id, String firstName, String lastName, String mobile, String birthdate, Short homeId){
         this.jdbcTemplate.update("update person set first_name=?, last_name=?, mobile=?, birthday=?, home_id=? where id= ?",
                new Object[] {firstName, lastName, mobile, birthdate, homeId, id});
        return new Person(id, firstName,lastName, mobile, birthdate, homeId);
    }

    public Person getPerson(Long id){
        List<Person> personList = findAll();
        for (Person p : personList) {
            if(p.getId()==id)
                return p;
        }
        return null;
    }

    public Person getPerson(String lastname){
        List<Person> personList = findAll();
        for (Person p : personList) {
            if(p.getLastName()==lastname)
                return p;
        }
        return null;
    }

    public Person getReverseLookup(String mobile){
        List<Person> personList = findAll();
        for (Person p : personList) {
            if(p.getMobile()==mobile)
                return p;
        }
        return null;
    }

    public int getFirstnameStats(String firstname){
        List<Person> personList = findAll();
        int stats = 0;
        for (Person p : personList) {
            if(p.getFirstName()==firstname)
                stats++;
        }
        return stats;
    }

}
