package org.jpb.jet;

import java.util.ArrayList;
import java.util.List;

import org.jpb.jet.generated.TestTemplate;

public class TestTemplateClient {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        List data = new ArrayList();
        data.add("first");
        data.add("second");
        data.add("third");
        
        TestTemplate generateXml = new TestTemplate();
        String result = generateXml.generate(data);
        System.out.println(result);
    }
}
