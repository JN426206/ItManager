package Hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(columnNames = ("login"))})
public class Users {

    @Id @GeneratedValue
    @Column(name = "idUsers")
    private int id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "password", nullable = false)
    private String password;

//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "Users_Business",
//            joinColumns = { @JoinColumn(name = "users_id")},
//            inverseJoinColumns = { @JoinColumn(name = "business_id")}
//    )
//    List<Business> businesses = new ArrayList<Business>();

    public Users() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

//    public List<Business> getBusinesses() {
//        return businesses;
//    }
//
//    public void setBusinesses(List<Business> businesses) {
//        this.businesses = businesses;
//    }
}
