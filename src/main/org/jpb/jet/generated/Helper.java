package org.jpb.jet.generated;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jpb.jaxb.model.PropertyOfProperties;

public class Helper {

    /**
     * Converts a pascal case (ThisIsPascalCase) string to camel (thisIsCamelCase) case
     * @param field the pascal case string to convert
     * @return the camel case quivalent
     */
    public static String toCamelCase(String field) {
        String convertedString = field;
        if(Character.isUpperCase(field.charAt(0))) {
            String toLower = (field.charAt(0) + "").toLowerCase();
            convertedString = toLower + field.substring(1);
        }
        
        return convertedString;
    }
    
    /**
     * Converts pascal case (ThisIsPascalCase) to COBOL (THIS_IS_COBOL_CASE) case
     * @param field the pascal case string to convert
     * @return the COBOL case equivalent
     */
    public static String toCobolCase(String field) {
        StringBuilder convertedStringBuilder = new StringBuilder();
        for(byte character : field.getBytes()) {
            if(Character.isUpperCase(character)) {
                convertedStringBuilder.append("_");
                convertedStringBuilder.append((char)character);
            }
            else {
                convertedStringBuilder.append(Character.toUpperCase((char)character));
            }
        }
        return convertedStringBuilder.toString();
    }
    
    /**
     * 
     * @param field
     * @return
     */
    public static String getJavaDataType(PropertyOfProperties field) {
        if(field.getValues().size() <= 1) {
            return PsJavaDatatypeMapping.fromPsType(field.getType()).getJavaType();
        }
        else {
            return "PropertyArrayProperty";
        }
    }
    
    enum PsJavaDatatypeMapping {
        UNKNOWN("","String"),
        System_String("System.String", "String"),
        System_Boolean("System.Boolean", "Boolean"),
        System_Int32("System.Int32", "Integer"),
        System_Decimal("System.Decimal", "Double");
        
        String javaType;
        String psType;
        
        private static final Map<String, PsJavaDatatypeMapping> LOOKUP = 
                Arrays.stream(PsJavaDatatypeMapping.values()).
                    collect(Collectors.toMap(PsJavaDatatypeMapping::getPsType, Function.identity()));
        
        PsJavaDatatypeMapping(String psType, String javaType) {
            this.psType = psType;
            this.javaType = javaType;
        }
        
        String getJavaType() {
            return this.javaType;
        }
        
        String getPsType() {
            return this.psType;
        }
        
        /**
         * Provides reverse lookup of powershell type to ordinal
         * @param psType to find
         * @return Field ordinal with the specified name
         */
        static PsJavaDatatypeMapping fromPsType(String psType) {
            PsJavaDatatypeMapping psTypeMapping = LOOKUP.get(psType);
            if(psTypeMapping == null) {
                psTypeMapping = PsJavaDatatypeMapping.UNKNOWN;
            }
            return psTypeMapping;
        }
    }
}
