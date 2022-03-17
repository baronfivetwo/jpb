package org.jpb.jaxb.unmarshall;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jpb.jaxb.model.Property;
import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.PropertyOfProperties;
import org.jpb.jaxb.model.StringProperty;

public class AddVmhostUnmarshaller {
    
    public static Map<String, Property> getPropertiesMap(String path) throws JAXBException, IOException {
        
        Map<String, Property> propertiesMap = new Hashtable<String, Property>();
        org.jpb.jaxb.schema.powercli.Objects objects = null;
        
        File file = new File(path);
        objects = convertXMLToObject(readFromInputStream(new FileInputStream(file)));
        
        org.jpb.jaxb.schema.powercli.Object object = objects.getObject();
        List<org.jpb.jaxb.schema.powercli.Property> properties = object.getProperty();
        for(org.jpb.jaxb.schema.powercli.Property property : properties) {
            String name = property.getName();
            String type = property.getType();
            
            for(Object val : property.getContent()) {
                
                if(val instanceof org.jpb.jaxb.schema.powercli.Property) {
                    org.jpb.jaxb.schema.powercli.Property propertyEntry = (org.jpb.jaxb.schema.powercli.Property)val;
                    PropertyArrayProperty propertyArrayProperty = (PropertyArrayProperty)propertiesMap.get(name);
                    propertyArrayProperty.getProperties().add(
                        new PropertyOfProperties(
                            propertyEntry.getName(), propertyEntry.getType(), propertyEntry.getContent()));
                }
                else if(!val.toString().startsWith("\n")) {
                    StringProperty stringProperty = new StringProperty(name, type, val.toString());
                    propertiesMap.put(name, stringProperty);
                }
                else {
                    
                    // If we are adding a new PropertyArrayProperty
                    if(!propertiesMap.containsKey(name)) {
                        List<PropertyOfProperties> propertyOfProperties = new ArrayList<>();
                        propertiesMap.put(name, new PropertyArrayProperty(name, type, propertyOfProperties));
                    }
                    else { // if we are appending to an existing PropertyArrayProperty
                        Property propertyEntry = propertiesMap.get(name);
                        List<PropertyOfProperties> propertyOfProperties = new ArrayList<>();
                        if(propertyEntry instanceof StringProperty) {
                            PropertyArrayProperty propertyArrayProperty = 
                                new PropertyArrayProperty(name, type, propertyOfProperties);
                            propertiesMap.put(name, propertyArrayProperty);
                        }
                    }
                }
            }
        }
        return propertiesMap;
    }
    
    private static String readFromInputStream(InputStream inputStream) {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

    private static org.jpb.jaxb.schema.powercli.Objects convertXMLToObject(String document) {
        org.jpb.jaxb.schema.powercli.Objects objects = null;
        try {
            JAXBContext context = JAXBContext.newInstance(org.jpb.jaxb.schema.powercli.Objects.class);
            Unmarshaller un = context.createUnmarshaller();
            objects = (org.jpb.jaxb.schema.powercli.Objects) un.unmarshal(
                new ByteArrayInputStream(document.getBytes(Charset.forName("UTF-8"))));
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
