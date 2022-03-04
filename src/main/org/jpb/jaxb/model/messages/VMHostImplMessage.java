package org.jpb.jaxb.model.messages;

import java.util.Arrays;
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
    private PropertyArrayProperty datastoreIdList;
    private PropertyArrayProperty message;
    
    // Fields for this message
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
                    this.datastoreIdList = new PropertyArrayProperty(
                        property.getName(), 
                        property.getType());
                    this.datastoreIdList.setProperties(property.getValues());
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

    /**
     * Getter for the state
     * @return The state value of the message
     */
    public String getState() {
        return state;
    }

    /**
     * Getter for the connection state
     * @return The connection state value of the message
     */
    public String getConnectionState() {
        return connectionState;
    }

    /**
     * Getter for the power state
     * @return The power state value of the message
     */
    public String getPowerState() {
        return powerState;
    }

    /**
     * Getter for the vm swap file datastore id
     * @return The vm swap file datastore id value of the message
     */
    public String getVmSwapfileDatastoreId() {
        return vMSwapfileDatastoreId;
    }

    /**
     * Getter for the vm swap file policy
     * @return The vm swap file policy value of the message
     */
    public String getVmSwapFilePolicy() {
        return vMSwapFilePolicy;
    }

    /**
     * Getter for the parent id
     * @return The parent id value of the message
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Getter for the standalone flag
     * @return The standalone flag of the message
     */
    public boolean isStandalone() {
        return isStandalone;
    }

    /**
     * Getter for the manufacturer
     * @return The manufacturer value of the message
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Getter for the model
     * @return The model value of the message
     */
    public String getModel() {
        return model;
    }

    /**
     * Getter for the num cpu
     * @return The num cpu value of the message
     */
    public int getNumCpu() {
        return numCpu;
    }

    /**
     * Getter for the cpu total mhz
     * @return The cpu total mhz value of the message
     */
    public int getCpuTotalMhz() {
        return cpuTotalMhz;
    }

    /**
     * Getter for the cpu usage mhz
     * @return The cpu usage mhz value of the message
     */
    public int getCpuUsageMhz() {
        return cpuUsageMhz;
    }

    /**
     * Getter for the license key
     * @return The license key value of the message
     */
    public String getLicenseKey() {
        return licenseKey;
    }

    /**
     * Getter for the memory total mb
     * @return The memory total mb value of the message
     */
    public double getMemoryTotalMB() {
        return memoryTotalMB;
    }

    /**
     * Getter for the memory total gb
     * @return The memory total gb value of the message
     */
    public double getMemoryTotalGB() {
        return memoryTotalGB;
    }

    /**
     * Getter for the memory usage mb
     * @return The memory usage mb value of the message
     */
    public double getMemoryUsageMB() {
        return memoryUsageMB;
    }

    /**
     * Getter for the memory usage gb
     * @return The memory usage gb value of the message
     */
    public double getMemoryUsageGB() {
        return memoryUsageGB;
    }

    /**
     * Getter for the processor type
     * @return The processor type of the message
     */
    public String getProcessorType() {
        return processorType;
    }

    /**
     * Getter for the hyperthreading active flag
     * @return The hyperthreading active flag of the message
     */
    public boolean isHyperthreadingActive() {
        return hyperthreadingActive;
    }

    /**
     * Getter for the time zone
     * @return The time zone value of the message
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Getter for the version
     * @return The version value of the message
     */
    public String getVersion() {
        return version;
    }

    /**
     * Getter for the build id
     * @return The build id of the message
     */
    public String getBuild() {
        return build;
    }

    /**
     * Getter for the parent
     * @return The parent value of the message
     */
    public String getParent() {
        return parent;
    }

    /**
     * Getter for the vm swap file datastore
     * @return The vm swap file datastore value of the message
     */
    public String getvMSwapfileDatastore() {
        return vMSwapfileDatastore;
    }

    /**
     * Getter for the storage info
     * @return The storage info value of the message
     */
    public String getStorageInfo() {
        return storageInfo;
    }

    /**
     * Getter for the network info
     * @return The network info value of the message
     */
    public String getNetworkInfo() {
        return networkInfo;
    }

    /**
     * Getter for the diagnostic partition
     * @return The diagnostic partition value of the message
     */
    public String getDiagnosticPartition() {
        return diagnosticPartition;
    }

    /**
     * Getter for the firewall default policy
     * @return The firewall default policy value of the message
     */
    public String getFirewallDefaultPolicy() {
        return firewallDefaultPolicy;
    }

    /**
     * Getter for the api version
     * @return The api version value of the message
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Getter for the max evc mode
     * @return The max evc mode value of the message
     */
    public String getMaxEvcMode() {
        return maxEvcMode;
    }

    /**
     * Getter for the crypto state
     * @return The crypto state value of the message
     */
    public String getCryptoState() {
        return cryptoState;
    }

    /**
     * Getter for the name
     * @return The name value of the message
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the extension data
     * @return The extension data value of the message
     */
    public String getExtensionData() {
        return extensionData;
    }

    /**
     * Getter for the id
     * @return The id value of the message
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for the uid
     * @return The uid value of the message
     */
    public String getUid() {
        return uid;
    }

    /**
     * Getter for the datastore id list
     * @return The datastore id list value of the message
     */
    public PropertyArrayProperty getDatastoreIdList() {
        return datastoreIdList;
    }
}