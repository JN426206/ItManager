package serialization;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JacksonSerializationTest {
    final static org.apache.log4j.Logger logger = Logger.getLogger(JacksonSerializationTest.class);

    @Before
    public void setUp() throws Exception {
        logger.info("Start JacksonSerializationTest");
    }

    @Test
    public void checkLoadJSON(){
        //new JacksonSerialization().
    }


}