package Hibernate.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Business.class)
@Entity
@Table(name = "Passwords")
public class Passwords {

    @JsonIgnore
    @Id @GeneratedValue
    @Column(name = "idPasswords")
    private int idPasswords;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    public Passwords() {}

    public Passwords(Business business) {
        this.business = business;
    }

    public int getIdPasswords() {
        return idPasswords;
    }

    @JsonIgnore
    public void setIdPasswords(int idPasswords) {
        this.idPasswords = idPasswords;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
