package org.jpb.jaxb.model.messages;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.PropertyOfProperties;
import org.jpb.jaxb.model.messages.exceptions.UnknownFieldException;

/**
 * This class provides a user friendly way to parse a VMHostImpl PowerCLI message
 *
 */
public class VMHostImplMessage extends ResponseMessage {

    private String state;
    private String connectionState;
    private String powerState;
    private String vMSwapfileDatastoreId;
    private String vMSwapfilePolicy;
    private String parentId;
    private Boolean isStandalone;
    private String manufacturer;
    private String model;
    private Integer numCpu;
    private Integer cpuTotalMhz;
    private Integer cpuUsageMhz;
    private String licenseKey;
    private Double memoryTotalMB;
    private Double memoryTotalGB;
    private Double memoryUsageMB;
    private Double memoryUsageGB;
    private String processorType;
    private Boolean hyperthreadingActive;
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
    private String maxEVCMode;
    private String cryptoState;
    private String name;
    private PropertyArrayProperty customFields;
    private String extensionData;
    private String id;
    private String uid;
    private PropertyArrayProperty datastoreIdList;
    private PropertyArrayProperty message;
    
    // Fields for this message
    enum Field {
        FIELD_STATE("State"),
        FIELD_CONNECTION_STATE("ConnectionState"),
        FIELD_POWER_STATE("PowerState"),
        FIELD_V_M_SWAPFILE_DATASTORE_ID("VMSwapfileDatastoreId"),
        FIELD_V_M_SWAPFILE_POLICY("VMSwapfilePolicy"),
        FIELD_PARENT_ID("ParentId"),
        FIELD_IS_STANDALONE("IsStandalone"),
        FIELD_MANUFACTURER("Manufacturer"),
        FIELD_MODEL("Model"),
        FIELD_NUM_CPU("NumCpu"),
        FIELD_CPU_TOTAL_MHZ("CpuTotalMhz"),
        FIELD_CPU_USAGE_MHZ("CpuUsageMhz"),
        FIELD_LICENSE_KEY("LicenseKey"),
        FIELD_MEMORY_TOTAL_M_B("MemoryTotalMB"),
        FIELD_MEMORY_TOTAL_G_B("MemoryTotalGB"),
        FIELD_MEMORY_USAGE_M_B("MemoryUsageMB"),
        FIELD_MEMORY_USAGE_G_B("MemoryUsageGB"),
        FIELD_PROCESSOR_TYPE("ProcessorType"),
        FIELD_HYPERTHREADING_ACTIVE("HyperthreadingActive"),
        FIELD_TIME_ZONE("TimeZone"),
        FIELD_VERSION("Version"),
        FIELD_BUILD("Build"),
        FIELD_PARENT("Parent"),
        FIELD_V_M_SWAPFILE_DATASTORE("VMSwapfileDatastore"),
        FIELD_STORAGE_INFO("StorageInfo"),
        FIELD_NETWORK_INFO("NetworkInfo"),
        FIELD_DIAGNOSTIC_PARTITION("DiagnosticPartition"),
        FIELD_FIREWALL_DEFAULT_POLICY("FirewallDefaultPolicy"),
        FIELD_API_VERSION("ApiVersion"),
        FIELD_MAX_E_V_C_MODE("MaxEVCMode"),
        FIELD_CRYPTO_STATE("CryptoState"),
        FIELD_NAME("Name"),
        FIELD_CUSTOM_FIELDS("CustomFields"),
        FIELD_EXTENSION_DATA("ExtensionData"),
        FIELD_ID("Id"),
        FIELD_UID("Uid"),
        FIELD_DATASTORE_ID_LIST("DatastoreIdList"),
        UNKNOWN("UNKNOWN");
        
        String name;
        private static final Map<String, Field> LOOKUP = 
            Arrays.stream(Field.values()).collect(Collectors.toMap(Field::getName, Function.identity()));
        
        /**
         * Sets the name value for this enum
         * @param name String to be set for name
         */
        Field(String name) {
            this.name = name;
        }
        
        /**
         * Gets the name value for this enum
         * @return string value for this enum
         */
        public String getName() {
            return this.name;
        }
        
        /**
         * Provides reverse lookup of name to ordinal
         * @param name Name to find
         * @return Field ordinal with the specified name
         */
        public static Field fromName(String name) {
            Field field = LOOKUP.get(name);
            if(field == null) {
                field = Field.UNKNOWN;
            }
            return field;
        }
    }
    
    // Message type assigned for this message
    public final static String MESSAGE_CLASS = "VMware.VimAutomation.ViCore.Impl.V1.Inventory.VMHostImpl";
    
    /**
     * Constructor that accepts a message in the form of a PropertyArrayProperty
     * @param message PropertyArrayProperty to be used to construct this message
     * @throws UnknownFieldException
     */
    public VMHostImplMessage(PropertyArrayProperty message) throws UnknownFieldException {
        this.message = message;
        build();
    }
    
    /**
     * method used by constructor to build the message
     * @throws UnknownFieldException
     */
    private void build() throws UnknownFieldException {
        for(PropertyOfProperties property : message.getProperties()) {
            Field field = Field.fromName(property.getName());
            
            switch(field) {
                case FIELD_STATE:
                    this.state = convert(property.getValues());
                    break;
                case FIELD_CONNECTION_STATE:
                    this.connectionState = convert(property.getValues());
                    break;
                case FIELD_POWER_STATE:
                    this.powerState = convert(property.getValues());
                    break;
                case FIELD_V_M_SWAPFILE_DATASTORE_ID:
                    this.vMSwapfileDatastoreId = convert(property.getValues());
                    break;
                case FIELD_V_M_SWAPFILE_POLICY:
                    this.vMSwapfilePolicy = convert(property.getValues());
                    break;
                case FIELD_PARENT_ID:
                    this.parentId = convert(property.getValues());
                    break;
                case FIELD_IS_STANDALONE:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.isStandalone = false;
                    }
                    else {
                        this.isStandalone = Boolean.parseBoolean((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MANUFACTURER:
                    this.manufacturer = convert(property.getValues());
                    break;
                case FIELD_MODEL:
                    this.model = convert(property.getValues());
                    break;
                case FIELD_NUM_CPU:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.numCpu = 0;
                    }
                    else {
                        this.numCpu = Integer.parseInt((String)property.getValues().get(0));
                    }
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
                case FIELD_LICENSE_KEY:
                    this.licenseKey = convert(property.getValues());
                    break;
                case FIELD_MEMORY_TOTAL_M_B:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryTotalMB = 0.0d;
                    }
                    else {
                        this.memoryTotalMB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MEMORY_TOTAL_G_B:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryTotalGB = 0.0d;
                    }
                    else {
                        this.memoryTotalGB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MEMORY_USAGE_M_B:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryUsageMB = 0.0d;
                    }
                    else {
                        this.memoryUsageMB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_MEMORY_USAGE_G_B:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.memoryUsageGB = 0.0d;
                    }
                    else {
                        this.memoryUsageGB = Double.parseDouble((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_PROCESSOR_TYPE:
                    this.processorType = convert(property.getValues());
                    break;
                case FIELD_HYPERTHREADING_ACTIVE:
                    if(property.getValues() == null || property.getValues().size() == 0) {
                        this.hyperthreadingActive = false;
                    }
                    else {
                        this.hyperthreadingActive = Boolean.parseBoolean((String)property.getValues().get(0));
                    }
                    break;
                case FIELD_TIME_ZONE:
                    this.timeZone = convert(property.getValues());
                    break;
                case FIELD_VERSION:
                    this.version = convert(property.getValues());
                    break;
                case FIELD_BUILD:
                    this.build = convert(property.getValues());
                    break;
                case FIELD_PARENT:
                    this.parent = convert(property.getValues());
                    break;
                case FIELD_V_M_SWAPFILE_DATASTORE:
                    this.vMSwapfileDatastore = convert(property.getValues());
                    break;
                case FIELD_STORAGE_INFO:
                    this.storageInfo = convert(property.getValues());
                    break;
                case FIELD_NETWORK_INFO:
                    this.networkInfo = convert(property.getValues());
                    break;
                case FIELD_DIAGNOSTIC_PARTITION:
                    this.diagnosticPartition = convert(property.getValues());
                    break;
                case FIELD_FIREWALL_DEFAULT_POLICY:
                    this.firewallDefaultPolicy = convert(property.getValues());
                    break;
                case FIELD_API_VERSION:
                    this.apiVersion = convert(property.getValues());
                    break;
                case FIELD_MAX_E_V_C_MODE:
                    this.maxEVCMode = convert(property.getValues());
                    break;
                case FIELD_CRYPTO_STATE:
                    this.cryptoState = convert(property.getValues());
                    break;
                case FIELD_NAME:
                    this.name = convert(property.getValues());
                    break;
                case FIELD_CUSTOM_FIELDS:
                    this.customFields = new PropertyArrayProperty(
                        property.getName(), 
                        property.getType());
                    this.customFields.setProperties(property.getValues());
                    break;
                case FIELD_EXTENSION_DATA:
                    this.extensionData = convert(property.getValues());
                    break;
                case FIELD_ID:
                    this.id = convert(property.getValues());
                    break;
                case FIELD_UID:
                    this.uid = convert(property.getValues());
                    break;
                case FIELD_DATASTORE_ID_LIST:
                    this.datastoreIdList = new PropertyArrayProperty(
                        property.getName(), 
                        property.getType());
                    this.datastoreIdList.setProperties(property.getValues());
                    break;
                case UNKNOWN:
                    throw new UnknownFieldException(MESSAGE_CLASS + ":" + property.getName());
            }
        }
    }

    /**
     * Getter for state
     * @return The state value of the message
     */
    public String getState() {
        return state;
    }
      
    /**
     * Getter for connectionState
     * @return The connectionState value of the message
     */
    public String getConnectionState() {
        return connectionState;
    }
      
    /**
     * Getter for powerState
     * @return The powerState value of the message
     */
    public String getPowerState() {
        return powerState;
    }
      
    /**
     * Getter for vMSwapfileDatastoreId
     * @return The vMSwapfileDatastoreId value of the message
     */
    public String getVMSwapfileDatastoreId() {
        return vMSwapfileDatastoreId;
    }
      
    /**
     * Getter for vMSwapfilePolicy
     * @return The vMSwapfilePolicy value of the message
     */
    public String getVMSwapfilePolicy() {
        return vMSwapfilePolicy;
    }
      
    /**
     * Getter for parentId
     * @return The parentId value of the message
     */
    public String getParentId() {
        return parentId;
    }
      
    /**
     * Getter for the isStandalone flag
     * @return The isStandalone flag of the message
     */
    public Boolean isIsStandalone() {
        return isStandalone;
    }
      
    /**
     * Getter for manufacturer
     * @return The manufacturer value of the message
     */
    public String getManufacturer() {
        return manufacturer;
    }
      
    /**
     * Getter for model
     * @return The model value of the message
     */
    public String getModel() {
        return model;
    }
      
    /**
     * Getter for numCpu 
     * @return The numCpu value of the message
     */
    public Integer getNumCpu() {
        return numCpu;
    }
      
    /**
     * Getter for cpuTotalMhz 
     * @return The cpuTotalMhz value of the message
     */
    public Integer getCpuTotalMhz() {
        return cpuTotalMhz;
    }
      
    /**
     * Getter for cpuUsageMhz 
     * @return The cpuUsageMhz value of the message
     */
    public Integer getCpuUsageMhz() {
        return cpuUsageMhz;
    }
      
    /**
     * Getter for licenseKey
     * @return The licenseKey value of the message
     */
    public String getLicenseKey() {
        return licenseKey;
    }
      
    /**
     * Getter for memoryTotalMB
     * @return The memoryTotalMB value of the message
     */
    public Double getMemoryTotalMB() {
        return memoryTotalMB;
    }
      
    /**
     * Getter for memoryTotalGB
     * @return The memoryTotalGB value of the message
     */
    public Double getMemoryTotalGB() {
        return memoryTotalGB;
    }
      
    /**
     * Getter for memoryUsageMB
     * @return The memoryUsageMB value of the message
     */
    public Double getMemoryUsageMB() {
        return memoryUsageMB;
    }
      
    /**
     * Getter for memoryUsageGB
     * @return The memoryUsageGB value of the message
     */
    public Double getMemoryUsageGB() {
        return memoryUsageGB;
    }
      
    /**
     * Getter for processorType
     * @return The processorType value of the message
     */
    public String getProcessorType() {
        return processorType;
    }
      
    /**
     * Getter for the hyperthreadingActive flag
     * @return The hyperthreadingActive flag of the message
     */
    public Boolean isHyperthreadingActive() {
        return hyperthreadingActive;
    }
      
    /**
     * Getter for timeZone
     * @return The timeZone value of the message
     */
    public String getTimeZone() {
        return timeZone;
    }
      
    /**
     * Getter for version
     * @return The version value of the message
     */
    public String getVersion() {
        return version;
    }
      
    /**
     * Getter for build
     * @return The build value of the message
     */
    public String getBuild() {
        return build;
    }
      
    /**
     * Getter for parent
     * @return The parent value of the message
     */
    public String getParent() {
        return parent;
    }
      
    /**
     * Getter for vMSwapfileDatastore
     * @return The vMSwapfileDatastore value of the message
     */
    public String getVMSwapfileDatastore() {
        return vMSwapfileDatastore;
    }
      
    /**
     * Getter for storageInfo
     * @return The storageInfo value of the message
     */
    public String getStorageInfo() {
        return storageInfo;
    }
      
    /**
     * Getter for networkInfo
     * @return The networkInfo value of the message
     */
    public String getNetworkInfo() {
        return networkInfo;
    }
      
    /**
     * Getter for diagnosticPartition
     * @return The diagnosticPartition value of the message
     */
    public String getDiagnosticPartition() {
        return diagnosticPartition;
    }
      
    /**
     * Getter for firewallDefaultPolicy
     * @return The firewallDefaultPolicy value of the message
     */
    public String getFirewallDefaultPolicy() {
        return firewallDefaultPolicy;
    }
      
    /**
     * Getter for apiVersion
     * @return The apiVersion value of the message
     */
    public String getApiVersion() {
        return apiVersion;
    }
      
    /**
     * Getter for maxEVCMode
     * @return The maxEVCMode value of the message
     */
    public String getMaxEVCMode() {
        return maxEVCMode;
    }
      
    /**
     * Getter for cryptoState
     * @return The cryptoState value of the message
     */
    public String getCryptoState() {
        return cryptoState;
    }
      
    /**
     * Getter for name
     * @return The name value of the message
     */
    public String getName() {
        return name;
    }
      
    /**
     * Getter for the customFields array
     * @return The customFields array of the message
     */
    public PropertyArrayProperty getCustomFields() {
        return customFields;
    }
      
    /**
     * Getter for extensionData
     * @return The extensionData value of the message
     */
    public String getExtensionData() {
        return extensionData;
    }
      
    /**
     * Getter for id
     * @return The id value of the message
     */
    public String getId() {
        return id;
    }
      
    /**
     * Getter for uid
     * @return The uid value of the message
     */
    public String getUid() {
        return uid;
    }
      
    /**
     * Getter for the datastoreIdList array
     * @return The datastoreIdList array of the message
     */
    public PropertyArrayProperty getDatastoreIdList() {
        return datastoreIdList;
    }
      
}
