package io.zipcoder.persistenceapp.person;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "birthday")
    private String birthDate;
    @Column(name = "home_id")
    private Short homeId;

    public Person(){

    }

    public Person(Long id, String firstName, String lastName, String mobile, String date, Short homeId) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile=mobile;
        this.birthDate=date;
        this.homeId = homeId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getHomeId() {
        return homeId;
    }

    public void setHomeId(Short homeId) {
        this.homeId = homeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
