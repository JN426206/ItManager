package Hibernate;

import Hibernate.model.Address;
import Hibernate.model.Business;
import Hibernate.model.Passwords;
import Hibernate.model.Users;
import Hibernate.queries.Queries;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Manager {
    public static void generateDate(EntityManager entityManager){
        Address address = new Address();
        address.setCity("Poznań");
        address.setCountry("Poland");
        address.setHouseNumber("23");
        address.setPostCode("60980");
        address.setStreet("Niestachowska");

        Users user = new Users();
        user.setLogin("Marek");
        user.setName("Marek");
        user.setSurname("Pils");
        user.setPassword("pass123");
        user.setAddress(address);
        DateTime date = DateTime.now();
        user.setPasswordExpired(date.plusMonths(6));


        Address addressBusines = new Address();
        addressBusines.setCity("Luboń");
        addressBusines.setCountry("Poland");
        addressBusines.setHouseNumber("15");
        addressBusines.setPostCode("67123");
        addressBusines.setStreet("Mokra");

        Business busines = new Business();
        busines.setName("Wytwórnia jedwabiu");
        busines.setAddress(addressBusines);
        busines.setNip("4485562598");
        busines.setRegon("569325478");

        Passwords password = new Passwords(busines);
        password.setPassword("123456789");
        password.setName("Komputer marka");

        Passwords password2 = new Passwords(busines);
        password2.setPassword("ala ma kota");
        password2.setName("WiFi biuro");
        password2.setComment("WiFi w biurze tylko na potrzeby księgowej");

        entityManager.persist(address);
        entityManager.persist(addressBusines);

        busines.getPasswords().add(password);
        busines.getPasswords().add(password2);

        entityManager.persist(busines);


        entityManager.persist(password);
        entityManager.persist(password2);


        user.getBusinesses().add(busines);

        entityManager.persist(user);

        entityManager.getTransaction().commit();
    }
    public static void main(String[] args) {
        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            generateDate(entityManager);

            System.out.println("Done");

            System.out.println(new Queries(entityManager).getAllUsers().size());
            for(Users findedUsers : new Queries(entityManager).getAllUsers()){
                System.out.println("Login: "+findedUsers.getLogin()+" Name: "+findedUsers.getName()+" surname: "+findedUsers.getSurname());
            }

            System.out.println(new Queries(entityManager).getAllPasswordsFromBusinessByNIP("4485562598").size());
            for (Passwords findedPasswords : new Queries(entityManager).getAllPasswordsFromBusinessByNIP("4485562598")) {
                System.out.println("Name: "+findedPasswords.getName()+" Password: "+findedPasswords.getPassword());
            }

            System.out.println(new Queries(entityManager).getAllPasswordsPagging().size());
            for(Passwords findedPasswords : new Queries(entityManager).getAllPasswordsPagging()){
                System.out.println("Name: "+findedPasswords.getName()+" Password: "+findedPasswords.getPassword());
            }

            System.out.println(new Queries(entityManager).getAllUserBusiness("Marek").size());
            for(Business findedBusiness : new Queries(entityManager).getAllUserBusiness("Marek")){
                System.out.println("Name: "+findedBusiness.getName()+" NIP: "+findedBusiness.getNip());
            }

            System.out.println(new Queries(entityManager).getAllAddress().size());
            for(Address findedAddress : new Queries(entityManager).getAllAddress()){
                System.out.println("City: "+findedAddress.getCity()+" PostCode: "+findedAddress.getPostCode());
            }

            entityManager.close();



        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }
    }

    public List<Users> readFromBaseAllDate(){

        System.out.println("Start readFromBaseAllDate");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            generateDate(entityManager);

            List<Users> users = new Queries(entityManager).getAllUsers();

            entityManager.close();

            return users;
        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            return null;
        } finally {
            entityManagerFactory.close();
            System.out.println("End readFromBaseAllDate");
        }
    }

    public void saveToDatabaseAllDate(List<Users> users){

        System.out.println("Start saveToDatabaseAllDate");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();
//            Address address = new Address();
//            address.setCity("Poznań");
//            address.setCountry("Poland");
//            address.setHouseNumber("23");
//            address.setPostCode("60980");
//            address.setStreet("Niestachowska");
//
//            Users user = new Users();
//            user.setLogin("Marek");
//            user.setName("Marek");
//            user.setSurname("Pils");
//            user.setPassword("pass123");
//            user.setAddress(address);
//            DateTime date = DateTime.now();
//            user.setPasswordExpired(date.plusMonths(6));
//            user.setAddress(address);
//            entityManager.persist(address);
//            user.setBusinesses(null);
//            entityManager.persist(user);

            for(Users user : users){

                System.out.println("Post code user: "+user.getAddress().getIdAddress());
                entityManager.persist(user.getAddress());
//                Address address = new Address();
//                address.setCity("Poznań");
//                address.setCountry("Poland");
//                address.setHouseNumber("23");
//                address.setPostCode("60980");
//                address.setStreet("Niestachowska");
//                user.setAddress(address);
//                user.setBusinesses(null);

                for(Business busines : user.getBusinesses()){

                    System.out.println("Post code business: "+busines.getAddress().getPostCode());
                    entityManager.persist(busines.getAddress());
                    //busines.setPasswords(null);
                    entityManager.persist(busines);
                    for(Passwords password : busines.getPasswords()){
                        System.out.println("Password busines: "+password.getPassword());
                        password.setBusiness(busines);
                        entityManager.persist(password);
                        //busines.getPasswords().add(password);
                    }


//                    for(Passwords password : busines.getPasswords()){
//                        //entityManager.persist(password);
//                    }

                    entityManager.persist(busines);
                    //user.getBusinesses().add(busines);

                }

                entityManager.persist(user);

            }



            entityManager.getTransaction().commit();

            entityManager.close();

        }catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
            System.out.println("End saveToDatabaseAllDate");
        }
    }
}
