package serialization;

import Hibernate.Manager;
import Hibernate.model.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class JacksonSerializationTest {
    final static org.apache.log4j.Logger logger = Logger.getLogger(JacksonSerializationTest.class);

    @Before
    public void setUp() throws Exception {
        logger.info("Start JacksonSerializationTest");
    }

    @Test
    public void checkLoadJSON(){
        try {
            logger.info("Start checkLoadJSON Test");
            ObjectMapper jsonMapper = new ObjectMapper();
            JacksonSerialization serialization = new JacksonSerialization();
            serialization.generateFirstJson(jsonMapper, "json");
            List<Users> users = serialization.loadJSON(jsonMapper, "json");
            assertEquals(2,users.size());
        }catch (IOException e){
            assertTrue(false);
            e.printStackTrace();
        } finally {
            logger.info("Stop checkLoadJSON Test");
        }
    }
    @Test
    public void checkSaveJSON(){
        try {
            logger.info("Start checkSaveJSON Test");
            ObjectMapper jsonMapper = new ObjectMapper();
            JacksonSerialization serialization = new JacksonSerialization();
            serialization.saveJSON(jsonMapper, new Manager().readFromBaseAllDate(), "json");
            List<Users> users = serialization.loadJSON(jsonMapper, "json");
            assertEquals(2,users.size());
        }catch (IOException e){
            assertTrue(false);
            e.printStackTrace();
        } finally {
            logger.info("Stop checkSaveJSON Test");
        }
    }

    @Test
    public void checkLoadXML(){
        try {
            logger.info("Start checkLoadXML Test");
            ObjectMapper XmlMapper = new XmlMapper();
            JacksonSerialization serialization = new JacksonSerialization();
            serialization.generateFirstJson(XmlMapper, "xml");
            List<Users> users = serialization.loadJSON(XmlMapper, "xml");
            assertEquals(2,users.size());
        }catch (IOException e){
            assertTrue(false);
            e.printStackTrace();
        } finally {
            logger.info("Stop checkLoadXML Test");
        }
    }
    @Test
    public void checkSaveXML(){
        try {
            logger.info("Start checkSaveXML Test");
            ObjectMapper XmlMapper = new XmlMapper();
            JacksonSerialization serialization = new JacksonSerialization();
            serialization.saveJSON(XmlMapper, new Manager().readFromBaseAllDate(), "xml");
            List<Users> users = serialization.loadJSON(XmlMapper, "xml");
            assertEquals(2,users.size());
        }catch (IOException e){
            assertTrue(false);
            e.printStackTrace();
        } finally {
            logger.info("Stop checkSaveXML Test");
        }
    }


}