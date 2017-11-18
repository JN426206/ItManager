package Hibernate;

import Hibernate.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    public static void main(String[] args) {
        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            Users user = new Users();
            user.setLogin("Marek");
            user.setName("Marek");
            user.setSurname("Pils");
            user.setPassword("pass123");

            entityManager.persist(user);

            entityManager.getTransaction().commit();

            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }
    }
}
