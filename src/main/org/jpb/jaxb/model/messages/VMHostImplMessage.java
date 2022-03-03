package org.jpb.jaxb.model.messages;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.PropertyOfProperties;
import org.jpb.jaxb.model.messages.exceptions.UnknownFieldException;

public class VMHostImplMessage extends ResponseMessage {

    private String state;
    private String connectionState;
    private String powerState;
    private String vMSwapfileDatastoreId;
    private String vMSwapFilePolicy;
    private String parentId;
    private boolean isStandalone;
    private String manufacturer;
    private String model;
    private int numCpu;
    private int cpuTotalMhz;
    private int cpuUsageMhz;
    private String licenseKey;
    private double memoryTotalMB;
    private double memoryTotalGB;
    private double memoryUsageMB;
    private double memoryUsageGB;
    private String processorType;
    private boolean hyperthreadingActive;
    private String timeZone;
    private String version;
    private String build;
    private String parent;
    private String vMSwapfileDatastore;
    private String storageInfo;
    private String networkInfo;
    private String diagnosticPartition;
    private String firewallDefaultPolicy;
    private String apiVersion;
    private String maxEvcMode;
    private String cryptoState;
    private String name;
    private String extensionData;
    private String id;
    private String uid;
    private List<Object> datastoreIdList;
    private PropertyArrayProperty message;
    
    enum Field {
        UNKNOWN("UNKNOWN"),
        FIELD_NUM_CPU("NumCpu"),
        FIELD_MODEL("Model"),
        FIELD_MANUFACTURER("Manufacturer"),
        FIELD_IS_STANDALONE("IsStandalone"),
        FIELD_PARENT_ID("ParentId"),
        FIELD_VM_SWAP_FILE_POLICY("VMSwapfilePolicy"),
        FIELD_VM_SWAP_FILE_DATASTORE_ID("VMSwapfileDatastoreId"),
        FIELD_POWER_STATE("PowerState"),
        FIELD_CONNECTION_STATE("ConnectionState"),
        FIELD_STATE("State"),
        FIELD_MEMORY_USAGE_GB("MemoryUsageGB"),
        FIELD_MEMORY_USAGE_MB("MemoryUsageMB"),
        FIELD_MEMORY_TOTAL_GB("MemoryTotalGB"),
        FIELD_MEMORY_TOTAL_MB("MemoryTotalMB"),
        FIELD_LICENSE_KEY("LicenseKey"),
        FIELD_CPU_USAGE_MHZ("CpuUsageMhz"),
        FIELD_CPU_TOTAL_MHZ("CpuTotalMhz"),
        FIELD_DATASTORE_ID_LIST("DatastoreIdList"),
        FIELD_UID("Uid"),
        FIELD_ID("Id"),
        FIELD_EXTENSION_DATA("ExtensionData"),
        FIELD_CUSTOM_FIELDS("CustomFields"),
        FIELD_NAME("Name"),
        FIELD_CRYPTO_STATE("CryptoState"),
        FIELD_MAX_EVC_MODE("MaxEVCMode"),
        FIELD_API_VERSION("ApiVersion"),
        FIELD_FIREWALL_DEFAULT_POLICY("FirewallDefaultPolicy"),
        FIELD_DIAGNOSTIC_PARTITION("DiagnosticPartition"),
        FIELD_NETWORK_INFO("NetworkInfo"),
        FIELD_STORAGE_INFO("StorageInfo"),
        FIELD_VM_SWAPFILE_DATASTORE("VMSwapfileDatastore"),
        FIELD_PARENT("Parent"),
        FIELD_BUILD("Build"),
        FIELD_VERSION("Version"),
        FIELD_TIME_ZONE("TimeZone"),
        FIELD_HYPERTHREADING_ACTIVE("HyperthreadingActive"),
        FIELD_PROCESSOR_TYPE("ProcessorType");
        
        
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
    
    public final static String MESSAGE_CLASS = "VMware.VimAutomation.ViCore.Impl.V1.Inventory.VMHostImpl";
    
    public VMHostImplMessage(PropertyArrayProperty message) throws UnknownFieldException {
        this.message = message;
        build();
    }
    
    private void build() throws UnknownFieldException {
        for(PropertyOfProperties property : message.getProperties()) {
            Field field = Field.fromName(property.getName());
            
            switch(field) {
                case FIELD_API_VERSION:
                    this.apiVersion = convert(property.getValues());
                    break;
                case FIELD_CONNECTION_STATE:
                    this.connectionState = convert(property.getValues());
                    break;
                case FIELD_BUILD:
                    this.build = convert(property.getValues());
                    break;
                case FIELD_CPU_TOTAL_MHZ:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.cpuTotalMhz = 0;
                    }
                    else {
                        this.cpuTotalMhz = Integer.parseInt((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_CPU_USAGE_MHZ:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.cpuUsageMhz = 0;
                    }
                    else {
                        this.cpuUsageMhz = Integer.parseInt((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_CRYPTO_STATE:
                    this.cryptoState = convert(property.getValues());
                    break;
                case FIELD_CUSTOM_FIELDS:
                    break;
                case FIELD_DATASTORE_ID_LIST:
                    this.datastoreIdList = property.getValues();
                    break;
                case FIELD_DIAGNOSTIC_PARTITION:
                    this.diagnosticPartition = convert(property.getValues());
                    break;
                case FIELD_EXTENSION_DATA:
                    this.extensionData = convert(property.getValues());
                    break;
                case FIELD_FIREWALL_DEFAULT_POLICY:
                    this.firewallDefaultPolicy = convert(property.getValues());
                    break;
                case FIELD_HYPERTHREADING_ACTIVE:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.hyperthreadingActive = false;
                    }
                    else {
                        this.hyperthreadingActive = Boolean.parseBoolean((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_ID:
                    this.id = convert(property.getValues());
                    break;
                case FIELD_IS_STANDALONE:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.isStandalone = false;
                    }
                    else {
                        this.isStandalone = Boolean.parseBoolean((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_LICENSE_KEY:
                    this.licenseKey = convert(property.getValues());
                    break;
                case FIELD_MANUFACTURER:
                    this.manufacturer = convert(property.getValues());
                    break;
                case FIELD_MAX_EVC_MODE:
                    this.maxEvcMode = convert(property.getValues());
                    break;
                case FIELD_MEMORY_TOTAL_GB:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryTotalGB = 0.0d;
                    }
                    else {
                        this.memoryTotalGB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MEMORY_TOTAL_MB:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryTotalMB = 0.0d;
                    }
                    else {
                        this.memoryTotalMB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MEMORY_USAGE_GB:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryUsageGB = 0.0d;
                    }
                    else {
                        this.memoryUsageGB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MEMORY_USAGE_MB:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryUsageMB = 0.0d;
                    }
                    else {
                        this.memoryUsageMB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MODEL:
                    this.model = convert(property.getValues());
                    break;
                case FIELD_NAME:
                    this.name = convert(property.getValues());
                    break;
                case FIELD_NETWORK_INFO:
                    this.networkInfo = convert(property.getValues());
                    break;
                case FIELD_NUM_CPU:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.numCpu = 0;
                    }
                    else {
                        this.numCpu = Integer.parseInt((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_PARENT:
                    this.parent = convert(property.getValues());
                    break;
                case FIELD_PARENT_ID:
                    this.parentId = convert(property.getValues());
                    break;
                case FIELD_POWER_STATE:
                    this.powerState = convert(property.getValues());
                    break;
                case FIELD_PROCESSOR_TYPE:
                    this.processorType = convert(property.getValues());
                    break;
                case FIELD_STATE:
                    this.state = convert(property.getValues());
                    break;
                case FIELD_STORAGE_INFO:
                    this.storageInfo = convert(property.getValues());
                    break;
                case FIELD_TIME_ZONE:
                    this.timeZone = convert(property.getValues());
                    break;
                case FIELD_UID:
                    this.uid = convert(property.getValues());
                    break;
                case FIELD_VERSION:
                    this.version = convert(property.getValues());
                    break;
                case FIELD_VM_SWAP_FILE_DATASTORE_ID:
                    this.vMSwapfileDatastoreId = convert(property.getValues());
                    break;
                case FIELD_VM_SWAP_FILE_POLICY:
                    this.vMSwapFilePolicy = convert(property.getValues());
                    break;
                case FIELD_VM_SWAPFILE_DATASTORE:
                    this.vMSwapfileDatastore = convert(property.getValues());
                    break;
                case UNKNOWN:
                    throw new UnknownFieldException(MESSAGE_CLASS + ":" + property.getName());
            }
        }
    }

    public String getState() {
        return state;
    }

    public String getConnectionState() {
        return connectionState;
    }

    public String getPowerState() {
        return powerState;
    }

    public String getvMSwapfileDatastoreId() {
        return vMSwapfileDatastoreId;
    }

    public String getvMSwapFilePolicy() {
        return vMSwapFilePolicy;
    }

    public String getParentId() {
        return parentId;
    }

    public boolean isStandalone() {
        return isStandalone;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getNumCpu() {
        return numCpu;
    }

    public int getCpuTotalMhz() {
        return cpuTotalMhz;
    }

    public int getCpuUsageMhz() {
        return cpuUsageMhz;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public double getMemoryTotalMB() {
        return memoryTotalMB;
    }

    public double getMemoryTotalGB() {
        return memoryTotalGB;
    }

    public double getMemoryUsageMB() {
        return memoryUsageMB;
    }

    public double getMemoryUsageGB() {
        return memoryUsageGB;
    }

    public String getProcessorType() {
        return processorType;
    }

    public boolean isHyperthreadingActive() {
        return hyperthreadingActive;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getVersion() {
        return version;
    }

    public String getBuild() {
        return build;
    }

    public String getParent() {
        return parent;
    }

    public String getvMSwapfileDatastore() {
        return vMSwapfileDatastore;
    }

    public String getStorageInfo() {
        return storageInfo;
    }

    public String getNetworkInfo() {
        return networkInfo;
    }

    public String getDiagnosticPartition() {
        return diagnosticPartition;
    }

    public String getFirewallDefaultPolicy() {
        return firewallDefaultPolicy;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getMaxEvcMode() {
        return maxEvcMode;
    }

    public String getCryptoState() {
        return cryptoState;
    }

    public String getName() {
        return name;
    }

    public String getExtensionData() {
        return extensionData;
    }

    public String getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public List<Object> getDatastoreIdList() {
        return datastoreIdList;
    }
}
