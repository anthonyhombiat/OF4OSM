/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagBooleanSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagComplexKey;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagDateIntervalValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagDateSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagKey;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagMultipleValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagNumericIntervalValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagNumericSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagStringIntervalValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagStringSimpleValue;
import lig.steamer.of4osm.folkso.tag.component.impl.OSMTagValue;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMComplexKeyBooleanPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMComplexKeyDateIntervalPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMComplexKeyDatePropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMComplexKeyNumericIntervalPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMComplexKeyNumericPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMComplexKeyStringIntervalPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMComplexKeyStringPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMDateIntervalPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMMultipleValuePropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMNumericIntervalPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMSimpleBooleanPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMSimpleDatePropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMSimpleNumericPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMSimpleStringPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMStringIntervalPropertyTag;
import lig.steamer.of4osm.folkso.tag.typology.impl.OSMTag;

/**
 *
 * @author amehiris
 */
public class test {

    public static void main(String[] args) throws MalformedURLException, IOException {

        //Category 
        Set simpleCategoryTag = new HashSet(); // OSMSimpleCategoryTag
        Set multipleValueCategoryTag = new HashSet(); //OSMMultipleValueCategoryTag
        //Property
        Set multipleValuePropertyTag = new HashSet();    //OSMMultipleValuePropertyTag

        Set simpleBooleanPropertyTag = new HashSet();    //OSMSimpleBooleanPropertyTag
        Set complexKeyBooleanPropertyTag = new HashSet();    //OSMComplexKeyBooleanPropertyTag

        Set stringIntervalPropertyTag = new HashSet();    //OSMStringIntervalPropertyTag
        Set complexKeyStringIntervalPropertyTag = new HashSet();    //OSMComplexKeyStringIntervalPropertyTag
        Set simpleStringPropertyTag = new HashSet();    //OSMSimpleStringPropertyTag
        Set complexKeyStringPropertyTag = new HashSet();    //OSMComplexKeyStringPropertyTag

        Set simpleNumericPropertyTag = new HashSet();    //OSMSimpleNumericPropertyTag
        Set complexKeyNumericPropertyTag = new HashSet();    //OSMComplexKeyNumericPropertyTag
        Set numericIntervalPropertyTag = new HashSet();    //OSMNumericIntervalPropertyTag
        Set complexKeyNumericIntervalPropertyTag = new HashSet();    //OSMComplexKeyNumericIntervalPropertyTag

        Set simpleDatePropertyTag = new HashSet();   //OSMSimpleDatePropertyTag
        Set complexKeyDatePropertyTag = new HashSet();   //OSMComplexKeyDatePropertyTag
        Set dateIntervalPropertyTag = new HashSet();   //OSMDateIntervalPropertyTag
        Set complexKeyDateIntervalPropertyTag = new HashSet();   //OSMComplexKeyDateIntervalPropertyTag

        String wikiURL = makeURL();

        URL url = new URL(wikiURL);

        //interogé le serveur OverPass et récupérer les objet java corespendant 
        ObjectMapper objectMapper = new ObjectMapper();
        HeadResult resultat = new HeadResult();
        resultat = objectMapper.readValue(url, HeadResult.class);
        System.out.println(resultat.toString());

        //parcourir la liste d'element 
        List<Elements> elements = resultat.getElements();
        for (int i = 0; i < elements.size(); i++) {

            //parcourir la map tags  
            Map tags = elements.get(i).getTags();
            Iterator j = tags.keySet().iterator();

            while (j.hasNext()) {
                //traitement de type de tags
                String clef = (String) j.next();
                String valeur = (String) tags.get(clef);

                OSMTagKey key = stringToKey(clef, wikiURL);
                OSMTagValue value = stringToValue(valeur);

                OSMTag type;
                if (OSMTagSimpleKey.class.isInstance(key)) {

                    if (OSMTagMultipleValue.class.isInstance(value)) {
                        //attention faut voir est-ce que Category ou Property 
                        type = new OSMMultipleValuePropertyTag((OSMTagSimpleKey) key, (OSMTagMultipleValue) value);
                        multipleValuePropertyTag.add(type);
                    }
                    if (OSMTagBooleanSimpleValue.class.isInstance(value)) {
                        type = new OSMSimpleBooleanPropertyTag((OSMTagSimpleKey) key, (OSMTagBooleanSimpleValue) value);
                        simpleBooleanPropertyTag.add(type);
                    }
                    if (OSMTagStringIntervalValue.class.isInstance(value)) {
                        type = new OSMStringIntervalPropertyTag((OSMTagSimpleKey) key, (OSMTagStringIntervalValue) value);
                        stringIntervalPropertyTag.add(type);
                    }
                    if (OSMTagStringSimpleValue.class.isInstance(value)) {
                        //attention Category or Property traiter apres inchAllah
                        type = new OSMSimpleStringPropertyTag((OSMTagSimpleKey) key, (OSMTagStringSimpleValue) value);
                        simpleStringPropertyTag.add(type);
                    }

                    if (OSMTagNumericSimpleValue.class.isInstance(value)) {
                        type = new OSMSimpleNumericPropertyTag((OSMTagSimpleKey) key, (OSMTagNumericSimpleValue) value);
                        simpleNumericPropertyTag.add(type);
                    }
                    if (OSMTagNumericIntervalValue.class.isInstance(value)) {
                        type = new OSMNumericIntervalPropertyTag((OSMTagSimpleKey) key, (OSMTagNumericIntervalValue) value);
                        numericIntervalPropertyTag.add(type);
                    }
                    if (OSMTagDateSimpleValue.class.isInstance(value)) {
                        type = new OSMSimpleDatePropertyTag((OSMTagSimpleKey) key, (OSMTagDateSimpleValue) value);
                        simpleDatePropertyTag.add(type);
                    }
                    if (OSMTagDateIntervalValue.class.isInstance(value)) {
                        type = new OSMDateIntervalPropertyTag((OSMTagSimpleKey) key, (OSMTagDateIntervalValue) value);
                        dateIntervalPropertyTag.add(type);
                    }
                }
                if (OSMTagComplexKey.class.isInstance(key)) {

                    if (OSMTagBooleanSimpleValue.class.isInstance(value)) {
                        type = new OSMComplexKeyBooleanPropertyTag((OSMTagComplexKey) key, (OSMTagBooleanSimpleValue) value);
                        complexKeyBooleanPropertyTag.add(type);
                    }
                    if (OSMTagStringIntervalValue.class.isInstance(value)) {
                        type = new OSMComplexKeyStringIntervalPropertyTag((OSMTagComplexKey) key, (OSMTagStringIntervalValue) value);
                        complexKeyStringIntervalPropertyTag.add(type);
                    }
                    if (OSMTagStringSimpleValue.class.isInstance(value)) {
                        type = new OSMComplexKeyStringPropertyTag((OSMTagComplexKey) key, (OSMTagStringSimpleValue) value);
                        complexKeyStringPropertyTag.add(type);
                    }
                    if (OSMTagNumericSimpleValue.class.isInstance(value)) {
                        type = new OSMComplexKeyNumericPropertyTag((OSMTagComplexKey) key, (OSMTagNumericSimpleValue) value);
                        complexKeyNumericPropertyTag.add(type);
                    }
                    if (OSMTagNumericIntervalValue.class.isInstance(value)) {
                        type = new OSMComplexKeyNumericIntervalPropertyTag((OSMTagComplexKey) key, (OSMTagNumericIntervalValue) value);
                        complexKeyNumericIntervalPropertyTag.add(type);
                    }
                    if (OSMTagDateSimpleValue.class.isInstance(value)) { 
                        type = new OSMComplexKeyDatePropertyTag((OSMTagComplexKey) key, (OSMTagDateSimpleValue) value);
                        complexKeyDatePropertyTag.add(type);
                    }
                    if (OSMTagDateIntervalValue.class.isInstance(value)) {
                        type = new OSMComplexKeyDateIntervalPropertyTag((OSMTagComplexKey) key, (OSMTagDateIntervalValue) value);
                        complexKeyDateIntervalPropertyTag.add(type);
                    }

                }
            }
        }
        System.out.println("Simple Value:");
        System.out.println("multipleValuePropertyTag\n"+multipleValuePropertyTag);
        System.out.println("simpleBooleanPropertyTag\n"+simpleBooleanPropertyTag);
        System.out.println("stringIntervalPropertyTag\n"+stringIntervalPropertyTag);
        System.out.println("simpleStringPropertyTag\n"+simpleStringPropertyTag);
        System.out.println("simpleNumericPropertyTag\n"+simpleNumericPropertyTag);
        System.out.println("numericIntervalPropertyTag\n"+numericIntervalPropertyTag);
        System.out.println("simpleDatePropertyTag\n"+simpleDatePropertyTag);
        System.out.println("dateIntervalPropertyTag\n"+dateIntervalPropertyTag);
        System.out.println("Complex Value:");
        System.out.println("complexKeyBooleanPropertyTag\n"+complexKeyBooleanPropertyTag);
        System.out.println("complexKeyStringIntervalPropertyTag\n"+complexKeyStringIntervalPropertyTag);
        System.out.println("complexKeyStringPropertyTag\n"+complexKeyStringPropertyTag);
        System.out.println("complexKeyNumericPropertyTag\n"+complexKeyNumericPropertyTag);
        System.out.println("complexKeyNumericIntervalPropertyTag\n"+complexKeyNumericIntervalPropertyTag);
        System.out.println("complexKeyDatePropertyTag\n"+complexKeyDatePropertyTag);
        System.out.println("complexKeyDateIntervalPropertyTag\n"+complexKeyDateIntervalPropertyTag);
        
        

    }

    public static String makeURL() {
        String BoundingBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
        String BoundingBoxGrenobleCentre = "(45.1873363,5.7180328,45.188529,5.724524)";

        //Construir l'url
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        str.append("http://overpass-api.de/api/interpreter?[out:json];(");
        System.out.println("Entrer le type d'element (node,way,relation)");
        String typeElement = sc.next();
        str.append(typeElement);
        str.append("[");
        System.out.println("Entrer le tag se forme clef = valeur ");
        String tag = sc.next();
        str.append(tag);
        str.append("]");
        str.append(BoundingBoxGrenobleCentre);
        str.append(";);out;");
        String wikiURL = str.toString();

        return wikiURL;
    }

    public static OSMTagKey stringToKey(String clef, String wikiURL) {
        OSMTagKey key;
        String[] clefs = clef.split(":");
        if (clefs.length == 1) {
            key = new OSMTagSimpleKey(clef, wikiURL);
        } else {
            key = new OSMTagComplexKey(clef, wikiURL);
        }
        return key;
    }

    public static OSMTagValue stringToValue(String valeur) {

        OSMTagValue value;
        //BolleanValue??
        if (valeur.equals("yes") || valeur.equals("non")) {
            value = new OSMTagBooleanSimpleValue(valeur);

        } else //DateValue ?? 
         if (isDate(valeur)) {
                if (isInervaleDate(valeur)) {
                    value = new OSMTagDateIntervalValue(valeur);
                } else {
                    value = new OSMTagDateSimpleValue(valeur);
                }
            } else {
                //NumericValue ??
                String[] values = valeur.split(";");
                if (values.length == 1) {
                    //NumericSimpleValue ??
                    try {
                        double d = Double.parseDouble(valeur);
                        value = new OSMTagNumericSimpleValue(d);
                    } catch (NumberFormatException nfe) {
                        //NumericIntervalValue?
                        String[] part = valeur.split("-");
                        if (part.length == 2) {
                            try {
                                double d1 = Double.parseDouble(part[0]);
                                double d2 = Double.parseDouble(part[1]);

                                value = new OSMTagNumericIntervalValue(d1, d2);

                            } catch (NumberFormatException e) {

                                value = new OSMTagStringIntervalValue(part[0], part[1]);

                            }
                        } else {
                            value = new OSMTagStringSimpleValue(valeur);
                        }
                    }
                } else {
                    value = new OSMTagMultipleValue(valeur);
                }
            }
        return value;
    }

    public static boolean isInervaleDate(String dateToValidate) {
        String[] dateFormats = {"yyyy-MM-dd'T'HH:mm:ss - yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM/dd - yyyy/MM/dd", "dd MMM yyyy - dd MMM yyyy"};
        boolean resultat = false;
        for (String dateFromat : dateFormats) {
            resultat = resultat || isThisDateValid(dateToValidate, dateFromat);
        }
        return resultat;
    }

    public static boolean isDate(String dateToValidate) {

        String[] dateFormats = {"yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM/dd", "dd MMM yyyy"};
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

}
