package org.jpb.jaxb.model.messages;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.PropertyOfProperties;
import org.jpb.jaxb.model.messages.exceptions.UnknownFieldException;

public class VIServerResponseMessage extends ResponseMessage {
    
    private boolean connected;
    private String id;
    private String serviceUri;
    private String sessionSecret;
    private String name;
    private String port;
    private String sessionId;
    private String user;
    private String uid;
    private String version;
    private String build;
    private String productLine;
    private String instanceUuid;
    private String refCount;
    private PropertyArrayProperty message;
    
    enum Field {
        UNKNOWN("UNKNOWN"),
        FIELD_CONNECTED("IsConnected"),
        FIELD_ID("Id"),
        FIELD_SERVICE_URI("ServiceUri"),
        FIELD_SESSION_SECRET("SessionSecret"),
        FIELD_NAME("Name"),
        FIELD_PORT("Port"),
        FIELD_SESSION_ID("SessionId"),
        FIELD_USER("User"),
        FIELD_UID("Uid"),
        FIELD_VERSION("Version"),
        FIELD_BUILD("Build"),
        FIELD_PRODUCT_LINE("ProductLine"),
        FIELD_INSTANCE_UUID("InstanceUuid"),
        FIELD_REF_COUNT("RefCount"),
        FIELD_EXTENSION_DATA("ExtensionData");
        
        String name;
        private static final Map<String, Field> LOOKUP = 
            Arrays.stream(Field.values()).collect(Collectors.toMap(Field::getName, Function.identity()));
        
        Field(String name) {
            this.name = name;
        }
        
        public String getName() {
            return this.name;
        }
        
        public static Field fromName(String name) {
            Field field = LOOKUP.get(name);
            if(field == null) {
                field = Field.UNKNOWN;
            }
            return field;
        }
    }
    
    public final static String MESSAGE_CLASS = "VMware.VimAutomation.ViCore.Impl.V1.VIServerImpl";
    
    public VIServerResponseMessage(PropertyArrayProperty message) throws UnknownFieldException {
        this.message = message;
        build();
    }
    
    private void build()  throws UnknownFieldException {
    
        for(PropertyOfProperties property : message.getProperties()) {
            
            Field field = Field.fromName(property.getName());
            
            switch(field) {
                case FIELD_CONNECTED:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.connected = false;
                    }
                    else {
                        this.connected = Boolean.parseBoolean((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_ID:
                    this.id = convert(property.getValues());
                    break;
                case FIELD_SERVICE_URI:
                    this.serviceUri = convert(property.getValues());
                    break;
                case FIELD_SESSION_SECRET:
                    this.sessionSecret = convert(property.getValues());
                    break;
                case FIELD_NAME:
                    this.name = convert(property.getValues());
                    break;
                case FIELD_PORT:
                    this.port = convert(property.getValues());
                    break;
                case FIELD_SESSION_ID:
                    this.sessionId = convert(property.getValues());
                    break;
                case FIELD_USER:
                    this.user = convert(property.getValues());
                    break;
                case FIELD_UID:
                    this.uid = convert(property.getValues());
                    break;
                case FIELD_VERSION:
                    this.version = convert(property.getValues());
                    break;
                case FIELD_BUILD:
                    this.build = convert(property.getValues());
                    break;
                case FIELD_PRODUCT_LINE:
                    this.productLine = convert(property.getValues());
                    break;
                case FIELD_INSTANCE_UUID:
                    this.instanceUuid = convert(property.getValues());
                    break;
                case FIELD_REF_COUNT:
                    this.refCount = convert(property.getValues());
                    break;
                case FIELD_EXTENSION_DATA:
                    //field is not needed
                case UNKNOWN:
                    throw new UnknownFieldException(MESSAGE_CLASS + ":" + property.getName());
            }
        }
    }
    
    public boolean isConnected() {
        return connected;
    }

    public String getId() {
        return id;
    }

    public String getServiceUri() {
        return serviceUri;
    }

    public String getSessionSecret() {
        return sessionSecret;
    }

    public String getName() {
        return name;
    }

    public String getPort() {
        return port;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUser() {
        return user;
    }

    public String getUid() {
        return uid;
    }

    public String getVersion() {
        return version;
    }

    public String getBuild() {
        return build;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getInstanceUuid() {
        return instanceUuid;
    }

    public String getRefCount() {
        return refCount;
    }
}
