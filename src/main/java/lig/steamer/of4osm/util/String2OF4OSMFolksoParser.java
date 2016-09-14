/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.util;

import lig.steamer.of4osm.core.folkso.tag.key.impl.PropertyTagKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lig.steamer.of4osm.core.folkso.tag.value.impl.LanguesCode;
import lig.steamer.of4osm.core.folkso.tag.value.impl.LifecycleState;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagDateValue;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagNumericValue;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagTimeDomainsValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMComplexKeyStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMLocalizedKeyStringValueTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTimeDomainsValuePropertyTag;
import lig.steamer.of4osm.util.openinghours.OpeningHour;

/**
 *
 * @author amehiris
 */
public class String2OF4OSMFolksoParser {

    public static OSMTag typeTags(OSMTagKey key, OSMTagValue value) {
        OSMTag type = null;
        if (OSMTagSimpleKey.class.isInstance(key)) {
            if (OSMTagMultipleValue.class.isInstance(value)) {
                //attention faut voir est-ce que Category ou PropertyTagKey 
                if (isProperty(key.getValue())) {
                    type = new OSMMultipleValuePropertyTag((OSMTagSimpleKey) key, (OSMTagMultipleValue) value);
                } else {
                    type = new OSMMultipleCategoryTag((OSMTagSimpleKey) key, (OSMTagMultipleValue) value);
                }
            }
            if (OSMTagBooleanValue.class.isInstance(value)) {
                type = new OSMSimpleBooleanPropertyTag((OSMTagSimpleKey) key, (OSMTagBooleanValue) value);
            }
            if (OSMTagStringValue.class.isInstance(value)) {
                //attention Category or PropertyTagKey traiter apres inchAllah

                if (isProperty(key.getValue())) {
                    type = new OSMSimpleStringPropertyTag((OSMTagSimpleKey) key, (OSMTagStringValue) value);
                } else {
                    type = new OSMSimpleCategoryTag((OSMTagSimpleKey) key, (OSMTagStringValue) value);
                }
            }
            if (OSMTagNumericValue.class.isInstance(value)) {
                type = new OSMSimpleNumericPropertyTag((OSMTagSimpleKey) key, (OSMTagNumericValue) value);
            }
            if (OSMTagDateValue.class.isInstance(value)) {
                type = new OSMSimpleDatePropertyTag((OSMTagSimpleKey) key, (OSMTagDateValue) value);
            }
            if (OSMTagTimeDomainsValue.class.isInstance(value)){
                type = new OSMTimeDomainsValuePropertyTag((OSMTagSimpleKey)key,(OSMTagTimeDomainsValue)value);
            }
        }
        if (OSMTagComplexKey.class.isInstance(key)) {
            if (OSMTagBooleanValue.class.isInstance(value)) {
                type = new OSMComplexKeyBooleanPropertyTag((OSMTagComplexKey) key, (OSMTagBooleanValue) value);
            }
            if (OSMTagStringValue.class.isInstance(value)) {
                type = new OSMComplexKeyStringPropertyTag((OSMTagComplexKey) key, (OSMTagStringValue) value);
            }
            if (OSMTagNumericValue.class.isInstance(value)) {
                type = new OSMComplexKeyNumericPropertyTag((OSMTagComplexKey) key, (OSMTagNumericValue) value);
            }
            if (OSMTagDateValue.class.isInstance(value)) {
                type = new OSMComplexKeyDatePropertyTag((OSMTagComplexKey) key, (OSMTagDateValue) value);
            }

        }
        if(OSMTagLocalizedKey.class.isInstance(key)){
            if(OSMTagStringValue.class.isInstance(value)){
                type = new OSMLocalizedKeyStringValueTag((OSMTagLocalizedKey)key,(OSMTagStringValue)value);
            }
        }
        if(OSMTagStatefulKey.class.isInstance(key)){
            if(OSMTagStringValue.class.isInstance(value)){
                type = new OSMStatefulCategoryTag((OSMTagStatefulKey)key,(OSMTagStringValue)value);
            }
        }       
        return type;       
    }

    public static boolean isProperty(String clef) {

        //from additional properties
        String[] property = {"addr",
            "attribution", "comment", "description", "email", "fax", "fixme", "image", "note", "phone",
            "source", "source_ref", "url", "todo", "website", "wikipedia",
            "name", "int_name", "loc_name", "nat_name", "official_name", "old_name", "reg_name", "short_name",
            "sorting_name", "alt_name",
            "area", "bridge", "charge", "covered", "crossing", "cutting", "disused", "drive_through", "drive_in",
            "electrified", "ele", "embankment", "end_date", "est_width", "fire_object", "fire_operator", "fire_rank",
            "frequency", "inscription", "internet_access", "layer", "leaf_cycle", "leaf_type", "location", "narrow",
            "nudism", "opening_hours", "operator", "start_date", "service_times", "tactile_paving", "tidal", "tunnel",
            "toilets", "wheelchair", "width",
            "iata", "icao", "int_ref", "lcn_ref", "loc_ref", "nat_ref", "ncn_ref", "old_ref", "rcn_ref", "ref", "reg_ref",
            "source_ref",
            "access", "agricultural", "atv", "bdouble", "bicycle", "boat", "emergency", "foot", "forestry", "goods",
            "hazmat", "hgv", "horse", "inline_skates", "lhv", "mofa", "moped", "motorboat", "motorcar", "motorcycle", "motor_vehicle",
            "psv", "roadtrain", "ski", "tank", "vehicle", "4wd_only", "charge", "maxheight", "maxlength", "maxspeed",
            "maxstay", "maxweight", "maxwidth", "minspeed", "noexit", "oneway", "Relation", "toll", "traffic_sign"};

        int i = 0;
        while (i < property.length && !property[i].equals(clef)) {
            i++;
        }
        return i != (property.length);
    }

    public static OSMTagKey stringToKey(String clef, String wikiURL) {
        OSMTagKey key;
        String[] clefs = clef.split(":");
        if (clefs.length == 1) {
            key = new OSMTagSimpleKey(clef, wikiURL);
        } else if ((clefs.length == 2) && (containslangueCode(clefs[1]))) {
            key = new OSMTagLocalizedKey(clef, wikiURL);
        } else if ((clefs.length == 2) && (containsLifecycleState(clefs[1]))) {
            key = new OSMTagStatefulKey(clef, wikiURL);
        } else {
            key = new OSMTagComplexKey(clef, wikiURL);
        }
        return key;
    }

    public static OSMTagValue stringToValue(String valeur) throws Exception {

        OSMTagValue value;
        //OpeningHours?
        if (OpeningHour.isOpeningHours(valeur)) {
            value = new OSMTagTimeDomainsValue(valeur);
        } else //BolleanValue??
        {
            if (valeur.equals("yes") || valeur.equals("no") || valeur.equals("oui") || valeur.equals("non")) {
                value = new OSMTagBooleanValue(valeur);

            } else //DateValue ?? 
            {
                if (isDate(valeur)) {
                    value = new OSMTagDateValue(valeur);

                } else {
                    //NumericValue ??
                    String[] values = valeur.split(";");
                    if (values.length == 1) {
                        //NumericSimpleValue ??
                        try {
                            double d = Double.parseDouble(valeur);
                            value = new OSMTagNumericValue(d);
                        } catch (NumberFormatException nfe) {

                            value = new OSMTagStringValue(valeur);

                        }
                    } else {
                        value = new OSMTagMultipleValue(valeur);
                    }
                }
            }
        }
        return value;
    }

    public static boolean isDate(String dateToValidate) {

        String[] dateFormats = {"yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM/dd", "dd MMM yyyy", "yyyy-MM-dd"};
        boolean resultat = false;
        for (String dateFromat : dateFormats) {
            resultat = resultat || isThisDateValid(dateToValidate, dateFromat);
        }
        return resultat;
    }

    public static boolean isThisDateValid(String dateToValidate, String dateFromat) {

        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);

        } catch (ParseException e) {

            return false;
        }

        return true;
    }

    public static boolean containslangueCode(String langueCode) {

        for (LanguesCode c : LanguesCode.values()) {
            if (c.name().equals(langueCode)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsLifecycleState(String lifecycleState) {

        for (LifecycleState c : LifecycleState.values()) {
            if (c.name().equals(lifecycleState)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsProperty(String property) {

        for (PropertyTagKey c : PropertyTagKey.values()) {
            if (c.toString().equals(property)) {
                return true;
            }
        }

        return false;
    }

    public static boolean parseOpeningHours(String s) throws Exception {
        return OpeningHour.isOpeningHours(s);
    }

}
