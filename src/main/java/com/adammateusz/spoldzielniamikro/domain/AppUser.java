package com.adammateusz.spoldzielniamikro.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.util.HashSet;
import java.util.List;
>>>>>>> security
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

<<<<<<< HEAD
    //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "appUser")
    private Set<Bill> billsList;
    @OneToOne
    private Apartment apartment;
    public Set<Bill> getBillsList() {
        return billsList;
    }
=======
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "appUser")
    @JsonIgnore
    private Set<Bill> billsList;


    public Set<Bill> getBillsList() {
        return billsList;
    }

>>>>>>> security
    public void setBillsList(Set<Bill> billsList) {
        this.billsList = billsList;
    }

    @Column(unique = true)
<<<<<<< HEAD
    private String login;
    private String password;
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
=======
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
>>>>>>> security
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

