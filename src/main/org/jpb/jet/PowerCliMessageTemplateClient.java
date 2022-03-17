package org.jpb.jet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.jpb.jaxb.model.PropertyArrayProperty;
import org.jpb.jaxb.model.messages.PowerCliResponseHeader;
import org.jpb.jaxb.model.messages.exceptions.UnknownMessageException;
import org.jpb.jaxb.unmarshall.AddVmhostUnmarshaller;
import org.jpb.jet.generated.PowerCliMessageTemplate;

public class PowerCliMessageTemplateClient {

    public static void main(String[] args) {
        // get the list of xsd files
        if(args.length > 0) {
            System.out.println(listFilesForFolder(new File(args[0])));
            // for each xml file
            for(File file : listFilesForFolder(new File(args[0]))) {
                Map<String, org.jpb.jaxb.model.Property> payloadMap = null;
                try {
                    payloadMap = AddVmhostUnmarshaller.getPropertiesMap(file.getAbsolutePath());
                } catch (JAXBException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                PowerCliResponseHeader header = null;
                if(payloadMap != null) {
                    try {
                        header = new PowerCliResponseHeader(payloadMap);
                    } catch (UnknownMessageException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                
                if(header != null) {
                    PropertyArrayProperty payload = header.getPayload();
                    PowerCliMessageTemplate generateJava = new PowerCliMessageTemplate();
                    String result = generateJava.generate(payload);
                    System.out.println(result);
                    
                    // only do once for now
                    break;
                }
            }
        }
    }
    
    public static List<File> listFilesForFolder(final File folder) {
        List<File> files = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.getName().endsWith(".xml")) {
                files.add(fileEntry);
            }
        }
        
        return files;
    }

}
