package io.zipcoder.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name="LAST_NAME")
    private String last_name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private LinkedHashSet<Address> addresses;

    public Customer(){}

    public Customer(String first_name, String last_name){
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LinkedHashSet<Address> getAddress() {
        return addresses;
    }

    public void setAddress(LinkedHashSet<Address> addresses) {
        this.addresses = addresses;
    }
}
