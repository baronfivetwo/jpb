package org.jpb.jaxb.model;

import java.util.List;

public class PropertyArrayProperty extends Property {
    
    private List<PropertyOfProperties> properties;

    public PropertyArrayProperty(String name, String type, List<PropertyOfProperties> properties) {
        super(name, type);
        this.properties = properties;
    }

    public List<PropertyOfProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyOfProperties> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "PropertyArrayProperty: name=" + getName() + ", type=" + getType() + ", properties=" + properties;
    }
    
    
}
