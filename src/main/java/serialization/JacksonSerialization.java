package serialization;

import Hibernate.Manager;
import Hibernate.model.Address;
import Hibernate.model.Business;
import Hibernate.model.Passwords;
import Hibernate.model.Users;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JacksonSerialization {
    final static org.apache.log4j.Logger logger = Logger.getLogger(JacksonSerialization.class);

    public static void generateFirstJson(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);;

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        List<Users> users = objectsCreator.getUsers();

        //Serialize to file and string
        mapper.writeValue(new File("dump." + fileSuffix), users);
        String jsonString = mapper.writeValueAsString(users);
        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(jsonString);

//        //Deserialize from file
//        Employee deserializedEmployee = mapper.readValue(
//                new File("result." + fileSuffix), Employee.class);
//
//        //Give a rise
//        deserializedEmployee.setSalary(deserializedEmployee.getSalary() * 2);
//
//        //Serialize back
//        mapper.writeValue(new File("result-modified." + fileSuffix), deserializedEmployee);
//        String modifiedJsonString = mapper.writeValueAsString(deserializedEmployee);
//        logger.info("Printing serialized modified object " + fileSuffix);
//        System.out.println(modifiedJsonString);
//
//        //Serialize generic List
//        List<Employee> employees = objectsCreator.getEmployees();
//        String employeesListSerialized = mapper.writeValueAsString(employees);
//        logger.info("Printing serialized employees list " + fileSuffix);
//        System.out.println(employeesListSerialized);

    }

    public static void saveJSON(ObjectMapper jsonMapper, List<Users> users, String fileSuffix){

        try {

//            for (Users user : users) {
//                for (Business busines : user.getBusinesses()) {
//                    for (Passwords password : busines.getPasswords()) {
//                        password.setBusiness(null);
//                    }
//                }
//            }

            //Set mapper to pretty-print
            jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonMapper.registerModule(new JodaModule());
            jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


            //Serialize to file and string
            jsonMapper.writeValue(new File("dump." + fileSuffix), users);
            String jsonString = jsonMapper.writeValueAsString(users);
            logger.info("Printing serialized original object " + fileSuffix);
            System.out.println(jsonString);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadJSON(ObjectMapper mapper, String fileSuffix) throws IOException {

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        //Deserialized employee object from employees.* file in resources
        //InputStream users = JacksonSerialization.class.getClassLoader().getResourceAsStream("dump." + fileSuffix);
        //List<Users> deserializedUsers = mapper.readValue(users, new TypeReference<List<Users>>(){});
        List<Users> deserializedUsers = mapper.readValue(new File("dump." + fileSuffix), new TypeReference<List<Users>>(){});
        //String modifiedSerialzied = mapper.writeValueAsString(deserializedUsers);
        logger.info("Printing modified re-serialized employee to" + fileSuffix);
        System.out.println(deserializedUsers.size());
        new Manager().saveToDatabaseAllDate(deserializedUsers);
    }

    public static void main(String [ ] args) throws IOException{

        ObjectMapper jsonMapper = new ObjectMapper();
        //generateFirstJson(jsonMapper, "json");
        saveJSON(jsonMapper, new Manager().readFromBaseAllDate(),"json");
        loadJSON(jsonMapper, "json");

        ObjectMapper xmlMapper = new XmlMapper();
        //generateFirstJson(xmlMapper, "xml");
        saveJSON(xmlMapper,new Manager().readFromBaseAllDate(),"xml");
        loadJSON(xmlMapper,"xml");
    }
}
