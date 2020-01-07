package com.adammateusz.spoldzielniamikro.domain;


import javax.persistence.*;
import java.util.Set;

@Table(name="appuser")
@Entity
public class AppUser {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String firstName;
    private String lastName;
    private String email;
    private String telephone;

    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "appUser")
    private Set<Bill> billsList;
    @OneToOne
    private Apartment apartment;
    public Set<Bill> getBillsList() {
        return billsList;
    }
    public void setBillsList(Set<Bill> billsList) {
        this.billsList = billsList;
    }

    @Column(unique = true)
    private String login;
    private String password;
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Apartment getApartment() { return apartment; }
    public void setApartment(Apartment apartment) { this.apartment = apartment; }
}

