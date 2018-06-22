package io.zipcoder.domain;


import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "STREET_ADDRESS_LINE_ONE")
    private String street_address_line_one;

    @Column(name = "STREET_ADDRESS_LINE_TWO")
    private String street_address_line_two;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP")
    private String zip;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ADDRESS_ID")
//    private Customer customer;

    public Address(){ }

    public Address(String street_address_line_one, String street_address_line_two, String city, String state, String zip){
        this.street_address_line_one = street_address_line_one;
        this.street_address_line_two = street_address_line_one;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet_address_line_one() {
        return street_address_line_one;
    }

    public void setStreet_address_line_one(String street_number) {
        this.street_address_line_one = street_number;
    }

    public String getStreet_address_line_two() {
        return street_address_line_two;
    }

    public void setStreet_address_line_two(String street_address_line_two) {
        this.street_address_line_two = street_address_line_two;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


}
