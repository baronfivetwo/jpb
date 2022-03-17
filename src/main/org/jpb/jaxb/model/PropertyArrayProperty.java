package org.jpb.jaxb.model;

import java.util.ArrayList;
import java.util.List;

public class PropertyArrayProperty extends Property {
    
    private List<PropertyOfProperties> properties = new ArrayList<>();

    public PropertyArrayProperty(String name, String type, List<PropertyOfProperties> properties) {
        super(name, type);
        this.properties = properties;
    }

    public PropertyArrayProperty(String name, String type) {
        this(name, type, new ArrayList<>());
    }
    
    public void setProperties(List<Object> properties) {
        this.properties.clear();
        for(Object obj : properties) {
            if(obj instanceof org.jpb.jaxb.schema.powercli.Property) {
                org.jpb.jaxb.schema.powercli.Property property = (org.jpb.jaxb.schema.powercli.Property)obj;
                PropertyOfProperties propertyOfProperties = 
                    new PropertyOfProperties(property.getName(), property.getType(), property.getContent());
                this.properties.add(propertyOfProperties);
            }
        }
    }

    public List<PropertyOfProperties> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "PropertyArrayProperty: name=" + getName() + ", type=" + getType() + ", properties=" + properties;
    }
    
    
}
