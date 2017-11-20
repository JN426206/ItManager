package serialization;

import Hibernate.Manager;
import Hibernate.model.Address;
import Hibernate.model.Business;
import Hibernate.model.Passwords;
import Hibernate.model.Users;
import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GsonSerialization {

    final static org.apache.log4j.Logger logger = Logger.getLogger(GsonSerialization.class);

    public static void generateFirstJson(){

//-------------------User 1-------------------------------------------------

//---------------------- Busines 1

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

        Passwords password = new Passwords();
        password.setPassword("123456789");
        password.setName("Komputer marka");

        Passwords password2 = new Passwords();
        password2.setPassword("ala ma kota");
        password2.setName("WiFi biuro");
        password2.setComment("WiFi w biurze tylko na potrzeby księgowej");

        busines.getPasswords().add(password);
        busines.getPasswords().add(password2);

//---------------------- Busines 2

        Address addressBusines2 = new Address();
        addressBusines2.setCity("Wrocław");
        addressBusines2.setCountry("Poland");
        addressBusines2.setHouseNumber("65");
        addressBusines2.setPostCode("45895");
        addressBusines2.setStreet("Poznańska");

        Business busines2 = new Business();
        busines2.setName("Warsztat samochodowy");
        busines2.setAddress(addressBusines2);
        busines2.setNip("1152284732");
        busines2.setRegon("456298759");

        Passwords passwordb2 = new Passwords();
        passwordb2.setPassword("Op0k@");
        passwordb2.setName("Serwer");

        Passwords passwordb22 = new Passwords();
        passwordb22.setPassword("P|0tk@");
        passwordb22.setName("NAS");
        passwordb22.setComment("NAS dla szefa");

        busines2.getPasswords().add(passwordb2);
        busines2.getPasswords().add(passwordb22);

//-------------------User 1-------------------------------------------------

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
        user.getBusinesses().add(busines);
        user.getBusinesses().add(busines2);
        DateTime date = DateTime.now();
        user.setPasswordExpired(date.plusMonths(6));
//--------------------------------------------------------------------------


//-------------------User 2-------------------------------------------------

//---------------------- Busines 1

        Address addressBusinesU2 = new Address();
        addressBusinesU2.setCity("Wrocław");
        addressBusinesU2.setCountry("Poland");
        addressBusinesU2.setHouseNumber("56");
        addressBusinesU2.setPostCode("48972");
        addressBusinesU2.setStreet("Wawrzyniaka");

        Business businesU2 = new Business();
        businesU2.setName("Szklania Piaska");
        businesU2.setAddress(addressBusinesU2);
        businesU2.setNip("1542265985");
        businesU2.setRegon("102648956");

        Passwords passwordU2 = new Passwords();
        passwordU2.setPassword("Qwerty!@#");
        passwordU2.setName("Komputer wojtka");

        Passwords password2U2 = new Passwords();
        password2U2.setPassword("zxcqaz!@#");
        password2U2.setName("WiFi goście");
        password2U2.setComment("WiFi dla gości w biurze");

        businesU2.getPasswords().add(passwordU2);
        businesU2.getPasswords().add(password2U2);

//---------------------- Busines 2

        Address addressBusines2U2 = new Address();
        addressBusines2U2.setCity("Wrocław");
        addressBusines2U2.setCountry("Poland");
        addressBusines2U2.setHouseNumber("65");
        addressBusines2U2.setPostCode("45895");
        addressBusines2U2.setStreet("Poznańska");

        Business busines2U2 = new Business();
        busines2U2.setName("Warsztat samochodowy");
        busines2U2.setAddress(addressBusines2U2);
        busines2U2.setNip("1152284732");
        busines2U2.setRegon("456298759");

        Passwords passwordb2U2 = new Passwords();
        passwordb2U2.setPassword("Op0k@");
        passwordb2U2.setName("Serwer");

        Passwords passwordb22U2 = new Passwords();
        passwordb22U2.setPassword("P|0tk@");
        passwordb22U2.setName("NAS");
        passwordb22U2.setComment("NAS dla szefa");

        busines2U2.getPasswords().add(passwordb2U2);
        busines2U2.getPasswords().add(passwordb22U2);

//-------------------User 2-------------------------------------------------

        Address addressU2 = new Address();
        addressU2.setCity("Wrocław");
        addressU2.setCountry("Poland");
        addressU2.setHouseNumber("23");
        addressU2.setPostCode("42985");
        addressU2.setStreet("Warszawska");

        Users userU2 = new Users();
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

        List<Users> users = new ArrayList<Users>();
        users.add(user);
        users.add(userU2);

        //Gson gsonPrettyS = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonPrettyS = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder().setPrettyPrinting()))).create();
        String prettySerializedAlbumS = gsonPrettyS.toJson(users);
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream("firstOutput.json");
            outputStream.write(prettySerializedAlbumS.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Gson gson = new Gson();
//        String serializedAlbum = gson.toJson(users);
//        logger.info("Print album json:");
//        System.out.println(serializedAlbum);

        //Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonPretty = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder().setPrettyPrinting()))).create();
        String prettySerializedAlbum = gsonPretty.toJson(users);
        logger.info("Pretty-print album json:");
        System.out.println(prettySerializedAlbum);

//        Users albumRed = gson.fromJson(serializedAlbum,Users.class);
//        System.out.println(albumRed.getName() + " " + albumRed.getLogin());
    }

    public static void saveJSON(List<Users> users){
        for(Users user : users){
            for(Business busines : user.getBusinesses()){
                for(Passwords password : busines.getPasswords()){
                    password.setBusiness(null);
                }
            }
        }
        //Gson gsonPrettyS = new GsonBuilder().setPrettyPrinting().create();
        Gson gsonPrettyS = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder().setPrettyPrinting()))).create();
        String prettySerializedAlbumS = gsonPrettyS.toJson(users);
        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream("Output.json");
            outputStream.write(prettySerializedAlbumS.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadJSON(String fileName){


        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            String json = sb.toString();
            Gson gson = Converters.registerDateMidnight(Converters.registerLocalTime(Converters.registerDateTime(new GsonBuilder()))).create();
            //Gson gson = new Gson();
            List<Users> users = gson.fromJson(json, new TypeToken<ArrayList<Users>>(){}.getType());
            new Manager().saveToDatabaseAllDate(users);
            System.out.println(users.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String [ ] args) {

        //generateFirstJson();
        saveJSON(new Manager().readFromBaseAllDate());
        //loadJSON("output.json");
        //loadJSON("firstOutput.json");
    }
}
