package org.jpb.jaxb.model;

import java.util.ArrayList;
import java.util.List;

public class PropertyOfProperties {

    private String name;
    private String type;
    private List<Object> values = new ArrayList<>();
    
    public PropertyOfProperties(String name, String type, List<Object> values) {
        this.name = name;
        this.type = type;
        this.values = values;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValue(List<Object> value) {
        this.values = value;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return 
            "\n\tPropertyOfProperties: Name=" + 
                name + 
                ", type=" + 
                type + 
                ", value=" + 
                values;
    }
}
