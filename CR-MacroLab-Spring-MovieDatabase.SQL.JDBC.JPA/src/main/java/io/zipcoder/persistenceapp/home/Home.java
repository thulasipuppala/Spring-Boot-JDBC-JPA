package io.zipcoder.persistenceapp.home;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Home {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "homenumber")
    private String homenumber;

    public Home(){}

    public Home(Long id, String address, String homenumber) {
        this.id = id;
        this.address = address;
        this.homenumber = homenumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public void setHomenumber(String homenumber) {
        this.homenumber = homenumber;
    }
}
