package org.jpb.jaxb.model.messages.exceptions;

public class UnknownMessageException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1703601038200509127L;
    
    
    public UnknownMessageException(String type) {
        super(type);
    }

}
