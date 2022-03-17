package org.jpb.jaxb.model.messages;

import java.util.List;

public class ResponseMessage {

    protected String convert(List<Object> values) {
        if(values == null || values.size() == 0) {
            return "";
        }
        else if(values.size() == 1){
            return (String)values.get(0);
        }
        else {
            return values.toString();
        }
    }
}
