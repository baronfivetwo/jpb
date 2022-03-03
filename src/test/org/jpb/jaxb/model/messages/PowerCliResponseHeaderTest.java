package org.jpb.jaxb.model.messages;

import java.util.Map;

import org.jpb.jaxb.model.Property;
import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.PropertyOfProperties;
import org.jpb.jaxb.unmarshall.AddVmhostUnmarshaller;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PowerCliResponseHeaderTest {

    PowerCliResponseHeader header = null;
    Map<String, Property> properties = null;
    
    public final static String INPUT_FILE = "C:\\Users\\robert\\Documents\\powercli-xml\\add-vmhost-message.xml";
    
    @BeforeClass
    public void setUp() {
        try {
            properties = AddVmhostUnmarshaller.getPropertiesMap(INPUT_FILE);
            header = new PowerCliResponseHeader(properties);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void getIdTest() {
        assert(header.getId() == 1l);
    }
    
    /**
     * <Property Name="State" Type="VMware.VimAutomation.ViCore.Types.V1.Host.VMHostState">Connected</Property>
        <Property Name="ConnectionState" Type="VMware.VimAutomation.ViCore.Types.V1.Host.VMHostState">Connected</Property>
        <Property Name="PowerState" Type="VMware.VimAutomation.ViCore.Types.V1.Host.VMHostPowerState">PoweredOn</Property>
        <Property Name="VMSwapfileDatastoreId" Type="System.String" />
        <Property Name="VMSwapfilePolicy" Type="VMware.VimAutomation.ViCore.Types.V1.VMSwapfilePolicy">Inherit</Property>
        <Property Name="ParentId" Type="System.String">ClusterComputeResource-domain-c57</Property>
        <Property Name="IsStandalone" Type="System.Boolean">False</Property>
        <Property Name="Manufacturer" Type="System.String">Dell Inc.</Property>
        <Property Name="Model" Type="System.String">PowerEdge T140</Property>
        <Property Name="NumCpu" Type="System.Int32">6</Property>
        <Property Name="CpuTotalMhz" Type="System.Int32">24048</Property>
        <Property Name="CpuUsageMhz" Type="System.Int32">0</Property>
        <Property Name="LicenseKey" Type="System.String">2N03J-NTH1L-28FG8-0U2UH-8EK50</Property>
        <Property Name="MemoryTotalMB" Type="System.Decimal">65122.55078125</Property>
        <Property Name="MemoryTotalGB" Type="System.Decimal">63.596240997314453125</Property>
        <Property Name="MemoryUsageMB" Type="System.Decimal">0</Property>
        <Property Name="MemoryUsageGB" Type="System.Decimal">0</Property>
        <Property Name="ProcessorType" Type="System.String">Intel(R) Xeon(R) E-2286G CPU @ 4.00GHz</Property>
        <Property Name="HyperthreadingActive" Type="System.Boolean">True</Property>
        <Property Name="TimeZone" Type="VMware.VimAutomation.ViCore.Impl.V1.Host.VMHostTimeZoneImpl">UTC</Property>
        <Property Name="Version" Type="System.String">7.0.3</Property>
        <Property Name="Build" Type="System.String">18644231</Property>
        <Property Name="Parent" Type="VMware.VimAutomation.ViCore.Impl.V1.Inventory.ClusterImpl">mycluster</Property>
        <Property Name="VMSwapfileDatastore" Type="VMware.VimAutomation.ViCore.Types.V1.DatastoreManagement.Datastore" />
        <Property Name="StorageInfo" Type="VMware.VimAutomation.ViCore.Impl.V1.Host.Storage.VMHostStorageInfoImpl">HostStorageSystem-storageSystem-61</Property>
        <Property Name="NetworkInfo" Type="VMware.VimAutomation.ViCore.Impl.V1.Host.Networking.VMHostNetworkInfoImpl">localhost:lan</Property>
        <Property Name="DiagnosticPartition" Type="VMware.VimAutomation.ViCore.Types.V1.Host.VMHostDiagnosticPartition" />
        <Property Name="FirewallDefaultPolicy" Type="VMware.VimAutomation.ViCore.Impl.V1.Host.VMHostFirewallDefaultPolicyImpl">VMHostFirewallDefaultPolicy:HostSystem-host-61</Property>
        <Property Name="ApiVersion" Type="System.String">7.0.3.0</Property>
        <Property Name="MaxEVCMode" Type="System.String">intel-broadwell</Property>
        <Property Name="CryptoState" Type="VMware.VimAutomation.ViCore.Types.V1.Security.HostCryptoState">Incapable</Property>
        <Property Name="Name" Type="System.String">192.168.86.203</Property>
        <Property Name="CustomFields" Type="VMware.VimAutomation.ViCore.Impl.V1.Util.ReadOnlyDictionary`2[System.String,System.String]">
          <Property Type="System.Collections.Generic.KeyValuePair`2[System.String,System.String]">[AutoDeploy.MachineIdentity, ]</Property>
        </Property>
        <Property Name="ExtensionData" Type="VMware.Vim.HostSystem">VMware.Vim.HostSystem</Property>
        <Property Name="Id" Type="System.String">HostSystem-host-61</Property>
        <Property Name="Uid" Type="System.String">/VIServer=vsphere.local\administrator@192.168.86.204:443/VMHost=HostSystem-host-61/</Property>
        <Property Name="DatastoreIdList" Type="System.String[]">
          <Property Type="System.String">Datastore-datastore-62</Property>
          <Property Type="System.String">Datastore-datastore-63</Property>
          <Property Type="System.String">Datastore-datastore-64</Property>
          <Property Type="System.String">Datastore-datastore-65</Property>
        </Property>
     */
    @Test
    public void getPayloadTest() {
        PropertyArrayProperty propertyArray = header.getPayload();
        assert(propertyArray != null);
    }
    
    @Test
    public void getTimestampTest() {
        assert(header.getTimestamp().getTime() == 1l);
    }
    
    @Test
    public void isSuccessTest() {
        assert(header.isSuccess() == true);
    }
}
