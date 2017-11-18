package Hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "Passwords")
public class Passwords {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "idPasswords")
    private int idPasswords;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    public Passwords() {}

    public int getIdPasswords() {
        return idPasswords;
    }

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

}
