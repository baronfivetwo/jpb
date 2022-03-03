package org.jpb.jaxb.model;

public class StringProperty extends Property {

    private String value;
    
    public StringProperty(String name, String type, String value) {
        super(name, type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StringProperty: name=" + getName() + ", type=" + getType() + ", value=" + value;
    }
    
    
}
