package Hibernate.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;
import java.util.List;

//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="refId", scope=Users.class)
@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = ("login"))})
public class Users {

    @Id @GeneratedValue
    @Column(name = "idUsers")
    @JsonIgnore
    private int idUsers;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "password", nullable = false)
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "passwordExpired", nullable = false)
    private DateTime passwordExpired;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Address_ID", referencedColumnName = "idAddress")
    Address address;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Users_Business",
            joinColumns = { @JoinColumn(name = "users_id")},
            inverseJoinColumns = { @JoinColumn(name = "business_id")}
    )
    List<Business> businesses = new ArrayList<Business>();

    public Users() {}

    public int getIdUsers() {
        return idUsers;
    }

    @JsonIgnore
    public void setIdUsers(int id) {
        this.idUsers = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public DateTime getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(DateTime passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
