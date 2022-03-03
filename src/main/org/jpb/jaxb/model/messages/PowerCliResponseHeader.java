package org.jpb.jaxb.model.messages;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;

import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.StringProperty;
import org.jpb.jaxb.model.messages.exceptions.UnknownFieldException;
import org.jpb.jaxb.model.messages.exceptions.UnknownMessageException;

public class PowerCliResponseHeader {

    private long id;
    private Date timestamp;
    private boolean success;
    private PropertyArrayProperty payload;
    private ResponseMessage responseMessage;
    
    private final static String FIELD_ID = "Id";
    private final static String FIELD_TIMESTAMP = "Timestamp";
    private final static String FIELD_SUCCESS = "IsSuccess";
    private final static String FIELD_PAYLOAD = "Payload";
    
    private final static Logger LOGGER = Logger.getLogger("PowerCliResponseHeader");
    
    public PowerCliResponseHeader(Map<String, org.jpb.jaxb.model.Property> message) throws UnknownMessageException {
        
        if(message.get(FIELD_ID) instanceof StringProperty) {
            this.id = Long.parseLong(((StringProperty)message.get(FIELD_ID)).getValue());
        }
        
        if(message.get(FIELD_TIMESTAMP) instanceof StringProperty) {
            this.timestamp = new Date(Long.parseLong(((StringProperty)message.get(FIELD_TIMESTAMP)).getValue()));
        }
        
        if(message.get(FIELD_SUCCESS) instanceof StringProperty) {
            this.success = Boolean.parseBoolean(((StringProperty)message.get(FIELD_SUCCESS)).getValue());
        }
        
        if(message.get(FIELD_PAYLOAD) instanceof PropertyArrayProperty) {
            this.payload = (PropertyArrayProperty)message.get(FIELD_PAYLOAD);

            MessageType messageType = MessageType.fromName(payload.getType());
            
            try {
                switch(messageType) {
                    case VI_SERVER_IMPL:
                        this.responseMessage = new VIServerResponseMessage(payload);
                        break;
                    case UNKNOWN:
                        throw new UnknownMessageException(payload.getType());
                }
            }
            catch(UnknownFieldException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
        }
    }

    public long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public PropertyArrayProperty getPayload() {
        return payload;
    }

    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }
}
