package Hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Business", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nip","regon"})
})
public class Business {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "idBusiness")
    private int idBusiness;

    @Column(name = "nip", nullable = false, unique = true)
    private String nip;

    @Column(name = "regon", nullable = false, unique = true)
    private String regon;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adress", nullable = false)
    private String adress;

//    @OneToMany(mappedBy = "business")
//    //@JoinColumn(name="idPasswords_ID", referencedColumnName = "idPasswords")
//    private List<Passwords> passwords = new ArrayList<Passwords>();
//
//    @ManyToMany(mappedBy = "business2")
//    private List<Users> users = new ArrayList<Users>();

    public Business() {}

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

//    public List<Passwords> getPasswords() {
//        return passwords;
//    }
//
//    public void setPasswords(List<Passwords> passwords) {
//        this.passwords = passwords;
//    }
//
//    public List<Users> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<Users> users) {
//        this.users = users;
//    }
}
