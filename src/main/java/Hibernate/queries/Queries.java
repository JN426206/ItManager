package Hibernate.queries;

import Hibernate.model.Address;
import Hibernate.model.Business;
import Hibernate.model.Passwords;
import Hibernate.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class Queries {
    EntityManager entityManager;

    public Queries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Users> getAllUsers(){
        Query query = entityManager.createQuery("SELECT k from Users k");
        return query.getResultList();
    }


    public List<Passwords> getAllPasswordsPagging(){ return getAllPasswordsPagging(0,10); }

    public List<Passwords> getAllPasswordsPagging(int startIndex){ return getAllPasswordsPagging(startIndex,10); }

    public List<Passwords> getAllPasswordsPagging(int startIndex, int numberItems){
        Query query = entityManager.createQuery("select k From Passwords k");
        query.setFirstResult(startIndex);
        query.setMaxResults(numberItems);
        return query.getResultList();
    }

    public List<Passwords> getAllPasswordsFromBusinessByNIP(String nip){
        Query query = entityManager.createQuery("SELECT k from Business k where k.nip = :busNIP")
                .setParameter("busNIP",nip);
        return ((Business) query.getResultList().get(0)).getPasswords();

    }

    public List<Address> getAllAddress(){
        Query query = entityManager.createQuery("select a from Address a");
        return query.getResultList();
    }

    public List<Business> getAllUserBusiness(String userLogin){

        Query query = entityManager.createQuery("select u from Users u where u.login = :userLogin")
                .setParameter("userLogin", userLogin);
        return ((Users) query.getSingleResult()).getBusinesses();

    }


}
