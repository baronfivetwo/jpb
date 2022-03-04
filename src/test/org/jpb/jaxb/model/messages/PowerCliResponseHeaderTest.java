package org.jpb.jaxb.model.messages;

import java.util.Map;

import org.jpb.jaxb.model.Property;
import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.unmarshall.AddVmhostUnmarshaller;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PowerCliResponseHeaderTest {

    PowerCliResponseHeader header = null;
    Map<String, Property> properties = null;
    
    public final static String INPUT_FILE = "C:\\Users\\robert\\Documents\\powercli-xml\\add-vmhost-message.xml";
    
    @BeforeClass
    public void setUp() {
        try {
            properties = AddVmhostUnmarshaller.getPropertiesMap(INPUT_FILE);
            header = new PowerCliResponseHeader(properties);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getIdTest() {
        assert(header.getId() == 1l);
    }
    
    @Test
    public void getPayloadTest() {
        PropertyArrayProperty propertyArray = header.getPayload();
        assert(propertyArray != null);
    }
    
    @Test
    public void getTimestampTest() {
        assert(header.getTimestamp().getTime() == 1l);
    }
    
    @Test
    public void isSuccessTest() {
        assert(header.isSuccess() == true);
    }
}
