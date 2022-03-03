package org.jpb.jaxb.model.messages;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MessageType {
    
    UNKNOWN("UNKNOWN"),
    VI_SERVER_IMPL("VMware.VimAutomation.ViCore.Impl.V1.VIServerImpl"),
    VM_HOST_IMPL("VMware.VimAutomation.ViCore.Impl.V1.Inventory.VMHostImpl");

    String name;
    private static final Map<String, MessageType> LOOKUP = 
        Arrays.stream(MessageType.values()).collect(Collectors.toMap(MessageType::getName, Function.identity()));
    
    
    MessageType(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public static MessageType fromName(String name) {
        MessageType messageType = LOOKUP.get(name);
        if(messageType == null) {
            messageType = MessageType.UNKNOWN;
        }
        return messageType;
    }
    
}
