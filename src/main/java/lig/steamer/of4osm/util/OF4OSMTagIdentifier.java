package lig.steamer.of4osm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMLocalizedKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTimeDomainsValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.AdditionalProperty;
import lig.steamer.of4osm.core.folkso.tag.key.impl.LanguageCode;
import lig.steamer.of4osm.core.folkso.tag.key.impl.LifecycleState;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagTimeDomainsValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagDateValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagNumericValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagTimeDomainsValue;
import lig.steamer.of4osm.util.openinghours.OpeningHours;

/**
 *
 * @author amehiris
 */
public class OF4OSMTagIdentifier {

    public static IOSMTag identifyTag(IOSMTagKey key, IOSMTagValue value) {
       
    	IOSMTag type = null;
        if (key instanceof IOSMTagSimpleKey) {
            if (value instanceof IOSMTagMultipleValue) {
                //attention faut voir est-ce que Category ou PropertyTagKey 
                if (isAdditionalProperty(key.getValue())) {
                    type = new OSMMultipleValuePropertyTag((IOSMTagSimpleKey) key, (IOSMTagMultipleValue) value);
                } else {
                    type = new OSMMultipleCategoryTag((IOSMTagSimpleKey) key, (IOSMTagMultipleValue) value);
                }
            }
            if (value instanceof IOSMTagBooleanValue) {
                type = new OSMSimpleKeyBooleanValuePropertyTag((IOSMTagSimpleKey) key, (IOSMTagBooleanValue) value);
            }
            if (value instanceof IOSMTagStringValue) {
                //attention Category or PropertyTagKey traiter apres inchAllah

                if (isAdditionalProperty(key.getValue())) {
                    type = new OSMSimpleKeyStringValuePropertyTag((IOSMTagSimpleKey) key, (IOSMTagStringValue) value);
                } else {
                    type = new OSMSimpleCategoryTag((IOSMTagSimpleKey) key, (IOSMTagStringValue) value);
                }
            }
            if (value instanceof IOSMTagNumericValue) {
                type = new OSMSimpleKeyNumericValuePropertyTag((IOSMTagSimpleKey) key, (IOSMTagNumericValue) value);
            }
            if (value instanceof IOSMTagDateValue) {
                type = new OSMSimpleKeyDateValuePropertyTag((IOSMTagSimpleKey) key, (IOSMTagDateValue) value);
            }
            if (value instanceof IOSMTagTimeDomainsValue){
                type = new OSMTimeDomainsValuePropertyTag((IOSMTagSimpleKey)key,(IOSMTagTimeDomainsValue)value);
            }
        }
        if (key instanceof IOSMTagComplexKey) {
            if (value instanceof IOSMTagBooleanValue) {
                type = new OSMComplexKeyBooleanValuePropertyTag((IOSMTagComplexKey) key, (IOSMTagBooleanValue) value);
            }
            if (value instanceof IOSMTagStringValue) {
                type = new OSMComplexKeyStringValuePropertyTag((IOSMTagComplexKey) key, (IOSMTagStringValue) value);
            }
            if (value instanceof IOSMTagNumericValue) {
                type = new OSMComplexKeyNumericValuePropertyTag((IOSMTagComplexKey) key, (IOSMTagNumericValue) value);
            }
            if (value instanceof IOSMTagDateValue) {
                type = new OSMComplexKeyDateValuePropertyTag((IOSMTagComplexKey) key, (IOSMTagDateValue) value);
            }

        }
        if(key instanceof IOSMTagLocalizedKey){
            if(value instanceof IOSMTagStringValue){
                type = new OSMLocalizedKeyStringValuePropertyTag((IOSMTagLocalizedKey)key,(IOSMTagStringValue)value);
            }
        }
        if(key instanceof IOSMTagStatefulKey){
            if(value instanceof IOSMTagStringValue){
                type = new OSMStatefulCategoryTag((IOSMTagStatefulKey)key,(IOSMTagStringValue)value);
            }
        }       
        return type;       
    }

    public static IOSMTagKey identifyKey(String k, String wikiURL) {
        String[] keys = k.split(":");
        if (keys.length == 1) {
        	return new OSMTagSimpleKey(k, wikiURL);
        } else if ((keys.length == 2) && (isLanguageCode(keys[1]))) {
        	return new OSMTagLocalizedKey(k, wikiURL);
        } else if ((keys.length == 2) && (isLifecycleState(keys[0]))) {
        	return new OSMTagStatefulKey(k, wikiURL);
        } else {
        	return new OSMTagComplexKey(k, wikiURL);
        }
    }

    public static IOSMTagValue identifyValue(String v) {
        if (OpeningHours.isOpeningHours(v)) {
        	return new OSMTagTimeDomainsValue(v);
        } else {
            if (v.equals("true") || v.equals("false") || v.equals("yes") || v.equals("no") || v.equals("oui") || v.equals("non")) {
            	return new OSMTagBooleanValue(v.equals("true") || v.equals("yes") || v.equals("oui"));
            } else {
            	Date date = parseDate(v);
                if (date != null) {
                	return  new OSMTagDateValue(date);
                } else {
                	 Double decimal = parseDouble(v);
                	 if(decimal != null){
                		 return new OSMTagNumericValue(decimal);
                     } else {
                    	 String[] values = v.split(";");
                         if (values.length == 1) {
                        	 return new OSMTagStringValue(v);
                         } else {
                        	 return new OSMTagMultipleValue(values);
                         }
                     }
                }
            }
        }
    }

    private static Double parseDouble(String s){
    	double d;
    	
    	try {
           d = Double.parseDouble(s);
           return d;
        } catch (NumberFormatException nfe) {}
    	
    	try {
            d = Double.parseDouble(s.replace(',', '.'));
            return d;
         } catch (NumberFormatException nfe) {}
    	
    	return null;
    }
    
    private static Date parseDate(String date) {
    	
        String[] dateFormats = {"yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM/dd", "yyyy-MM-dd", "d MMM yyyy"};
       
        DateFormat formatter;
        for (String dateFormat : dateFormats) {
        	
            formatter = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
            formatter.setLenient(false);

            try {
            	return formatter.parse(date);
            } catch (ParseException e) {
                
            }
        }
        
        return null;
    }

    private static boolean isLanguageCode(String languageCode) {

        for (LanguageCode c : LanguageCode.values()) {
            if (c.name().equals(languageCode)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isLifecycleState(String lifecycleState) {

        for (LifecycleState c : LifecycleState.values()) {
            if (c.name().equals(lifecycleState)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isAdditionalProperty(String additionalProperty) {

        for (AdditionalProperty c : AdditionalProperty.values()) {
            if (c.toString().equals(additionalProperty)) {
                return true;
            }
        }

        return false;
    }

}
