package org.jpb.jaxb.model.messages;

import java.util.List;
import java.util.Map;

import org.jpb.jaxb.model.Property;
import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.PropertyOfProperties;
import org.jpb.jaxb.unmarshall.AddVmhostUnmarshaller;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VMHostImplMessageTest {

public final static String INPUT_FILE = "C:\\Users\\robert\\Documents\\powercli-xml\\add-vmhost-message.xml";
    
    VMHostImplMessage vmHostImpl = null;
    
    @BeforeClass
    public void setUp() {
        
        Map<String, Property> properties = null;
        PropertyArrayProperty propertyArray = null;
        
        try {
            properties = AddVmhostUnmarshaller.getPropertiesMap(INPUT_FILE);
            assert(properties != null);
            PowerCliResponseHeader header = new PowerCliResponseHeader(properties);
            assert(header != null);
            propertyArray = header.getPayload();
            assert(propertyArray != null);
            assert(propertyArray.getType().equals(MessageType.VM_HOST_IMPL.getName()));
            vmHostImpl = new VMHostImplMessage(propertyArray);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

  @Test
  public void getApiVersionTest() {
      assert(vmHostImpl.getApiVersion().equals("7.0.3.0"));
  }

  @Test
  public void getBuildTest() {
      assert(vmHostImpl.getBuild().equals("18644231"));
  }

  @Test
  public void getConnectionStateTest() {
      assert(vmHostImpl.getConnectionState().equals("Connected"));
  }

  @Test
  public void getCpuTotalMhzTest() {
      assert(vmHostImpl.getCpuTotalMhz() == 24048);
  }

  @Test
  public void getCpuUsageMhzTest() {
      assert(vmHostImpl.getCpuUsageMhz() == 0);
  }

  @Test
  public void getCryptoStateTest() {
      assert(vmHostImpl.getCryptoState().equals("Incapable"));
  }

  @Test
  public void getDatastoreIdListTest() {
      PropertyArrayProperty datastoreIdList = vmHostImpl.getDatastoreIdList();
      assert(datastoreIdList != null);
      assert(datastoreIdList.getProperties().size() == 4);
      int i = 0;
      for(PropertyOfProperties datastore : datastoreIdList.getProperties()) {
          String val = (String) datastore.getValues().get(0);
          if(i == 0) {
              assert(val.equals("Datastore-datastore-62"));
          }
          else if(i == 1) {
              assert(val.equals("Datastore-datastore-63"));
          }
          else if(i == 2) {
              assert(val.equals("Datastore-datastore-64"));
          }
          else if(i == 3) {
              assert(val.equals("Datastore-datastore-65"));
          }
          i++;
      }
  }

  @Test
  public void getDiagnosticPartitionTest() {
      assert(vmHostImpl.getDiagnosticPartition().equals(""));
  }

  @Test
  public void getExtensionDataTest() {
      assert(vmHostImpl.getExtensionData().equals("VMware.Vim.HostSystem"));
  }

  @Test
  public void getFirewallDefaultPolicyTest() {
      assert(vmHostImpl.getFirewallDefaultPolicy().equals("VMHostFirewallDefaultPolicy:HostSystem-host-61"));
  }

  @Test
  public void getIdTest() {
      assert(vmHostImpl.getId().equals("HostSystem-host-61"));
  }

  @Test
  public void getIsStandaloneTest() {
      assert(vmHostImpl.isStandalone() == false);
  }

  @Test
  public void getLicenseKeyTest() {
      assert(vmHostImpl.getLicenseKey().equals("2N03J-NTH1L-28FG8-0U2UH-8EK50"));
  }

  @Test
  public void getManufacturerTest() {
      assert(vmHostImpl.getManufacturer().equals("Dell Inc."));
  }

  @Test
  public void getMaxEvcModeTest() {
      assert(vmHostImpl.getMaxEvcMode().equals("intel-broadwell"));
  }

  @Test
  public void getMemoryTotalGBTest() {
      assert(vmHostImpl.getMemoryTotalGB() == 63.596240997314453125d);
  }

  @Test
  public void getMemoryTotalMBTest() {
      assert(vmHostImpl.getMemoryTotalMB() == 65122.55078125d);
  }

  @Test
  public void getMemoryUsageGBTest() {
      assert(vmHostImpl.getMemoryUsageGB() == 0d);
  }

  @Test
  public void getMemoryUsageMBTest() {
      assert(vmHostImpl.getMemoryUsageMB() == 0d);
  }

  @Test
  public void getModelTest() {
      assert(vmHostImpl.getModel().equals("PowerEdge T140"));
  }

  @Test
  public void getNameTest() {
      assert(vmHostImpl.getName().equals("192.168.86.203"));
  }

  @Test
  public void getNetworkInfoTest() {
      assert(vmHostImpl.getNetworkInfo().equals("localhost:lan"));
  }

  @Test
  public void getNumCpuTest() {
      assert(vmHostImpl.getNumCpu() == 6);
  }

  @Test
  public void getParentTest() {
      assert(vmHostImpl.getParent().equals("mycluster"));
  }

  @Test
  public void getParentIdTest() {
      assert(vmHostImpl.getParentId().equals("ClusterComputeResource-domain-c57"));
  }

  @Test
  public void getPowerStateTest() {
      assert(vmHostImpl.getPowerState().equals("PoweredOn"));
  }

  @Test
  public void getProcessorTypeTest() {
      assert(vmHostImpl.getProcessorType().equals("Intel(R) Xeon(R) E-2286G CPU @ 4.00GHz"));
  }

  @Test
  public void getStateTest() {
      assert(vmHostImpl.getState().equals("Connected"));
  }

  @Test
  public void getStorageInfoTest() {
      assert(vmHostImpl.getStorageInfo().equals("HostStorageSystem-storageSystem-61"));
  }

  @Test
  public void getTimeZoneTest() {
      assert(vmHostImpl.getTimeZone().equals("UTC"));
  }

  @Test
  public void getUidTest() {
      assert(vmHostImpl.getUid().equals("/VIServer=vsphere.local\\administrator@192.168.86.204:443/VMHost=HostSystem-host-61/"));
  }

  @Test
  public void getVersionTest() {
      assert(vmHostImpl.getVersion().equals("7.0.3"));
  }

  @Test
  public void getvMSwapFilePolicyTest() {
      assert(vmHostImpl.getVmSwapFilePolicy().equals("Inherit"));
  }

  @Test
  public void getvMSwapfileDatastoreTest() {
      assert(vmHostImpl.getvMSwapfileDatastore().equals(""));
  }

  @Test
  public void getvMSwapfileDatastoreIdTest() {
      assert(vmHostImpl.getVmSwapfileDatastoreId().equals(""));
  }

  @Test
  public void isHyperthreadingActiveTest() {
      assert(vmHostImpl.isHyperthreadingActive() == true);
  }
}
