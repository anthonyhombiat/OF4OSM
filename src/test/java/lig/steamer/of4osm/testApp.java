package lig.steamer.of4osm;

import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagDateValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagNumericValue;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagComplexKey;
import lig.steamer.of4osm.ws.overpass.OverPassElement;
import lig.steamer.of4osm.ws.overpass.OverPassResponse;

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

/**
 * Hello world!
 *
 */
public class testApp {

    public static void main(String[] args) throws MalformedURLException, IOException {

        String wikiURL = makeURL();

        URL url = new URL(wikiURL);

        //interogé le serveur OverPass et récupérer les objet java corespendant 
        ObjectMapper objectMapper = new ObjectMapper();
        OverPassResponse resultat = new OverPassResponse();
        resultat = objectMapper.readValue(url, OverPassResponse.class);
        System.out.println(resultat.toString());

        //Key
        Set<OSMTagSimpleKey> simpleKeys= new HashSet<>();
        Set<OSMTagComplexKey> complexKeys = new HashSet<>();
        
        //Value
        Set<OSMTagBooleanValue> booleanValues = new HashSet<>();
        Set<OSMTagDateValue> dateValues = new HashSet<>();
        Set<OSMTagNumericValue> numericValues = new HashSet<>();
        Set<OSMTagStringValue> stringValues = new HashSet<>();
        Set <OSMTagMultipleValue> multipleValues = new HashSet<>();

        //parcourir la liste d'element 
        List<OverPassElement> elements = resultat.getElements();
        for (int i = 0; i < elements.size(); i++) {

            //parcourir la map tags  
            Map<String, String> tags = elements.get(i).getTags();
            Iterator<String> j = tags.keySet().iterator();

            while (j.hasNext()) {
                //traitement de type de tags

                String clef = (String) j.next();
                String valeur = (String) tags.get(clef);

                //traitement clef valeur 
                //traitement clef
                OSMTagKey key;
                System.out.print(clef + ":    ");
                String[] clefs = clef.split(":");
                if (clefs.length == 1) {
                    System.out.println("c'est un SimpleKey");
                    key = new OSMTagSimpleKey(clef, wikiURL);
                    simpleKeys.add((OSMTagSimpleKey) key);
                } else {
                    System.out.println("c'est un ComplexKey");
                    key = new OSMTagComplexKey(clef, wikiURL);
                    complexKeys.add((OSMTagComplexKey) key);
                    System.out.println(key);
                }
                //traitement valeur
                OSMTagValue value;
                System.out.print(valeur + "\t");
                if (valeur.equals("yes") || valeur.equals("oui") || valeur.equals("true") || valeur.equals("no")
                        || valeur.equals("non") || valeur.equals("false")) {
                    value = new OSMTagBooleanValue(valeur);
                    booleanValues.add((OSMTagBooleanValue) value);
                } else //DateValue ?? 
                 if (isDate(valeur)) {

                        System.out.println("\u001B[32m" + "c'est un DateeValue");//green --teste--> [public_transport=stop_position]

                        value = new OSMTagDateValue(valeur);
                        dateValues.add((OSMTagDateValue) value);

                    } else {

                        //NumericValue ??
                        String[] values = valeur.split(";");
                        if (values.length == 1) {
                            //NumericSimpleValue ??
                            try {
                                double d = Double.parseDouble(valeur);
                                System.out.println("\u001B[33m" + "c'est un NumericValue");//YELLOW
                                value = new OSMTagNumericValue(d);
                                numericValues.add((OSMTagNumericValue) value);
                            } catch (NumberFormatException nfe) {

                                System.out.println("\u001B[35m" + "C'est un StringSimpleValue");//PURPLE 
                                value = new OSMTagStringValue(valeur);
                                stringValues.add((OSMTagStringValue) value);

                            }

                        } else {
                            System.out.println("\u001B[31m" + "C'est un MultipleValue");//red 
                            value = new OSMTagMultipleValue(valeur);
                            multipleValues.add((OSMTagMultipleValue) value);
                        }
                    }

            }

        }
        
        System.out.println("OSMTagSimpleKey:\n" + simpleKeys);

        System.out.println("OSMTagComplexKey:\n" + complexKeys);

        System.out.println("OSMTagBooleanValue:\n" + booleanValues);

        System.out.println("OSMTagNumericValue:\n" + numericValues);

        System.out.println("OSMTagStringValue:\n" + stringValues);

        System.out.println("OSMTagMultipleValue\n" + multipleValues);

        System.out.println("OSMTagDateValue:\n" + dateValues);
        
    }

    public static String makeURL() {
        String BoundingBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
//        String BoundingBoxGrenobleCentre = "(45.1873363,5.7180328,45.188529,5.724524)";

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
        str.append(BoundingBoxGrenoble);
        str.append(";);out;");
        String wikiURL = str.toString();

        return wikiURL;
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
            System.out.println(date);

        } catch (ParseException e) {

            return false;
        }

        return true;
    }

}
