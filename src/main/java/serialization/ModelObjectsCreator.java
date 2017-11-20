package serialization;

import Hibernate.model.Address;
import Hibernate.model.Business;
import Hibernate.model.Passwords;
import Hibernate.model.Users;
import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ModelObjectsCreator {


    Address addressBusines = new Address();
    Business busines = new Business();
    Passwords password = new Passwords(busines);
    Passwords password2 = new Passwords(busines);
    Address addressBusines2 = new Address();
    Business busines2 = new Business();
    Passwords passwordb2 = new Passwords(busines2);
    Passwords passwordb22 = new Passwords(busines2);
    Address address = new Address();
    Users user = new Users();
    Address addressBusinesU2 = new Address();
    Business businesU2 = new Business();
    Passwords passwordU2 = new Passwords(businesU2);
    Passwords password2U2 = new Passwords(businesU2);
    Address addressBusines2U2 = new Address();
    Business busines2U2 = new Business();
    Passwords passwordb2U2 = new Passwords(busines2U2);
    Passwords passwordb22U2 = new Passwords(busines2U2);
    Address addressU2 = new Address();
    Users userU2 = new Users();

    List<Users> users = new ArrayList<Users>();

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Address getAddressBusines() {
        return addressBusines;
    }

    public void setAddressBusines(Address addressBusines) {
        this.addressBusines = addressBusines;
    }

    public Business getBusines() {
        return busines;
    }

    public void setBusines(Business busines) {
        this.busines = busines;
    }

    public Passwords getPassword() {
        return password;
    }

    public void setPassword(Passwords password) {
        this.password = password;
    }

    public Passwords getPassword2() {
        return password2;
    }

    public void setPassword2(Passwords password2) {
        this.password2 = password2;
    }

    public Address getAddressBusines2() {
        return addressBusines2;
    }

    public void setAddressBusines2(Address addressBusines2) {
        this.addressBusines2 = addressBusines2;
    }

    public Business getBusines2() {
        return busines2;
    }

    public void setBusines2(Business busines2) {
        this.busines2 = busines2;
    }

    public Passwords getPasswordb2() {
        return passwordb2;
    }

    public void setPasswordb2(Passwords passwordb2) {
        this.passwordb2 = passwordb2;
    }

    public Passwords getPasswordb22() {
        return passwordb22;
    }

    public void setPasswordb22(Passwords passwordb22) {
        this.passwordb22 = passwordb22;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Address getAddressBusinesU2() {
        return addressBusinesU2;
    }

    public void setAddressBusinesU2(Address addressBusinesU2) {
        this.addressBusinesU2 = addressBusinesU2;
    }

    public Business getBusinesU2() {
        return businesU2;
    }

    public void setBusinesU2(Business businesU2) {
        this.businesU2 = businesU2;
    }

    public Passwords getPasswordU2() {
        return passwordU2;
    }

    public void setPasswordU2(Passwords passwordU2) {
        this.passwordU2 = passwordU2;
    }

    public Passwords getPassword2U2() {
        return password2U2;
    }

    public void setPassword2U2(Passwords password2U2) {
        this.password2U2 = password2U2;
    }

    public Address getAddressBusines2U2() {
        return addressBusines2U2;
    }

    public void setAddressBusines2U2(Address addressBusines2U2) {
        this.addressBusines2U2 = addressBusines2U2;
    }

    public Business getBusines2U2() {
        return busines2U2;
    }

    public void setBusines2U2(Business busines2U2) {
        this.busines2U2 = busines2U2;
    }

    public Passwords getPasswordb2U2() {
        return passwordb2U2;
    }

    public void setPasswordb2U2(Passwords passwordb2U2) {
        this.passwordb2U2 = passwordb2U2;
    }

    public Passwords getPasswordb22U2() {
        return passwordb22U2;
    }

    public void setPasswordb22U2(Passwords passwordb22U2) {
        this.passwordb22U2 = passwordb22U2;
    }

    public Address getAddressU2() {
        return addressU2;
    }

    public void setAddressU2(Address addressU2) {
        this.addressU2 = addressU2;
    }

    public Users getUserU2() {
        return userU2;
    }

    public void setUserU2(Users userU2) {
        this.userU2 = userU2;
    }

    public void init(){
//-------------------User 1-------------------------------------------------

//---------------------- Busines 1

        addressBusines.setCity("Luboń");
        addressBusines.setCountry("Poland");
        addressBusines.setHouseNumber("15");
        addressBusines.setPostCode("67123");
        addressBusines.setStreet("Mokra");

        busines.setName("Wytwórnia jedwabiu");
        busines.setAddress(addressBusines);
        busines.setNip("4485562598");
        busines.setRegon("569325478");

        password.setPassword("123456789");
        password.setName("Komputer marka");

        password2.setPassword("ala ma kota");
        password2.setName("WiFi biuro");
        password2.setComment("WiFi w biurze tylko na potrzeby księgowej");

        busines.getPasswords().add(password);
        busines.getPasswords().add(password2);

//---------------------- Busines 2

        addressBusines2.setCity("Wrocław");
        addressBusines2.setCountry("Poland");
        addressBusines2.setHouseNumber("65");
        addressBusines2.setPostCode("45895");
        addressBusines2.setStreet("Poznańska");

        busines2.setName("Warsztat samochodowy");
        busines2.setAddress(addressBusines2);
        busines2.setNip("1152284732");
        busines2.setRegon("456298759");

        passwordb2.setPassword("Op0k@");
        passwordb2.setName("Serwer");

        passwordb22.setPassword("P|0tk@");
        passwordb22.setName("NAS");
        passwordb22.setComment("NAS dla szefa");

        busines2.getPasswords().add(passwordb2);
        busines2.getPasswords().add(passwordb22);

//-------------------User 1-------------------------------------------------

        address.setCity("Poznań");
        address.setCountry("Poland");
        address.setHouseNumber("23");
        address.setPostCode("60980");
        address.setStreet("Niestachowska");

        user.setLogin("Marek");
        user.setName("Marek");
        user.setSurname("Pils");
        user.setPassword("pass123");
        user.setAddress(address);
        user.getBusinesses().add(busines);
        user.getBusinesses().add(busines2);
        DateTime date = DateTime.now();
        user.setPasswordExpired(date.plusMonths(6));
//--------------------------------------------------------------------------


//-------------------User 2-------------------------------------------------

//---------------------- Busines 1

        addressBusinesU2.setCity("Wrocław");
        addressBusinesU2.setCountry("Poland");
        addressBusinesU2.setHouseNumber("56");
        addressBusinesU2.setPostCode("48972");
        addressBusinesU2.setStreet("Wawrzyniaka");

        businesU2.setName("Szklania Piaska");
        businesU2.setAddress(addressBusinesU2);
        businesU2.setNip("1542265985");
        businesU2.setRegon("102648956");

        passwordU2.setPassword("Qwerty!@#");
        passwordU2.setName("Komputer wojtka");

        password2U2.setPassword("zxcqaz!@#");
        password2U2.setName("WiFi goście");
        password2U2.setComment("WiFi dla gości w biurze");

        businesU2.getPasswords().add(passwordU2);
        businesU2.getPasswords().add(password2U2);

//---------------------- Busines 2

        addressBusines2U2.setCity("Wrocław");
        addressBusines2U2.setCountry("Poland");
        addressBusines2U2.setHouseNumber("65");
        addressBusines2U2.setPostCode("45895");
        addressBusines2U2.setStreet("Poznańska");

        busines2U2.setName("Warsztat samochodowy");
        busines2U2.setAddress(addressBusines2U2);
        busines2U2.setNip("1152284732");
        busines2U2.setRegon("456298759");

        passwordb2U2.setPassword("Op0k@");
        passwordb2U2.setName("Serwer");

        passwordb22U2.setPassword("P|0tk@");
        passwordb22U2.setName("NAS");
        passwordb22U2.setComment("NAS dla szefa");

        busines2U2.getPasswords().add(passwordb2U2);
        busines2U2.getPasswords().add(passwordb22U2);

//-------------------User 2-------------------------------------------------

        addressU2.setCity("Wrocław");
        addressU2.setCountry("Poland");
        addressU2.setHouseNumber("23");
        addressU2.setPostCode("42985");
        addressU2.setStreet("Warszawska");

        userU2.setLogin("TadeuszN");
        userU2.setName("Tadeusz");
        userU2.setSurname("Nowicki");
        userU2.setPassword("h@s|0!@#");
        userU2.setAddress(addressU2);
        userU2.getBusinesses().add(businesU2);
        userU2.getBusinesses().add(busines2U2);
        DateTime dateU2 = DateTime.now();
        user.setPasswordExpired(dateU2.plusMonths(6));
//--------------------------------------------------------------------------

        users.add(user);
        users.add(userU2);

    }
    public ModelObjectsCreator() { init(); }
}
