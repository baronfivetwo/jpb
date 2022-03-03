package org.jpb.jaxb.model.messages.exceptions;

public class UnknownFieldException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 5486594127051735853L;
    
    public UnknownFieldException(String field) {
        super(field);
    }

}
