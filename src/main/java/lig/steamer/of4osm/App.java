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

import lig.steamer.of4osm.folkso.tag.component.impl.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws MalformedURLException, IOException {

        String wikiURL = makeURL();

        URL url = new URL(wikiURL);

        //interogé le serveur OverPass et récupérer les objet java corespendant 
        ObjectMapper objectMapper = new ObjectMapper();
        HeadResult resultat = new HeadResult();
        resultat = objectMapper.readValue(url, HeadResult.class);
        System.out.println(resultat.toString());

        //Key
        Set simpleKey = new HashSet();
        Set complexKey = new HashSet();
        //Value
        Set bolleanSimpleValue = new HashSet();
        Set dateSimpleValue = new HashSet();
        Set numericSimpleValue = new HashSet();
        Set stringSimpleValue = new HashSet();
        Set numericIntervalValue = new HashSet();
        Set stringIntervalValue = new HashSet();
        Set multipleValue = new HashSet();

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

                //traitement clef valeur 
                //traitement clef
                OSMTagKey key;
                System.out.print(clef + ":    ");
                String[] clefs = clef.split(":");
                if (clefs.length == 1) {
                    System.out.println("c'est un SimpleKey");
                    key = new OSMTagSimpleKey(clef, wikiURL);
                    simpleKey.add(key);
                } else {
                    System.out.println("c'est un ComplexKey");
                    key = new OSMTagComplexKey(clef, wikiURL);
                    complexKey.add(key);
                    System.out.println(key);
                }
                //traitement valeur
                OSMTagValue value;
                System.out.print(valeur + "\t");
                if (valeur.equals("yes") || valeur.equals("oui") || valeur.equals("true") || valeur.equals("no")
                        || valeur.equals("non") || valeur.equals("false")) {
                    value = new OSMTagBooleanSimpleValue(valeur);
                    bolleanSimpleValue.add(value);
                } else //DateValue ?? 
                 if (isDate(valeur)) {
                        if (isInervaleDate(valeur)) {
                            System.out.println("\u001B[32m" + "c'est un DateIntervalValue");

                            value = new OSMTagDateIntervalValue(valeur);

                        } else {
                            System.out.println("\u001B[32m" + "c'est un DateSimpleValue");//green --teste--> [public_transport=stop_position]
                            //traitement pur voir si DateSimpleValue ou DateInterval
                            value = new OSMTagDateSimpleValue(valeur);
                            dateSimpleValue.add(value);
                        }
                    } else {

                        //NumericValue ??
                        String[] values = valeur.split(";");
                        if (values.length == 1) {
                            //NumericSimpleValue ??
                            try {
                                double d = Double.parseDouble(valeur);
                                System.out.println("\u001B[33m" + "c'est un NumericSimpleValue");//YELLOW
                                value = new OSMTagNumericSimpleValue(d);
                                numericSimpleValue.add(value);
                            } catch (NumberFormatException nfe) {
                                //NumericIntervalValue?
                                String[] part = valeur.split("-");
                                if (part.length == 2) {
                                    try {
                                        double d1 = Double.parseDouble(part[0]);
                                        double d2 = Double.parseDouble(part[1]);
                                        System.out.println("\u001B[34m" + "c'est un NumericIntervalValue");//blue --test--> [amenity=cafe]
                                        value = new OSMTagNumericIntervalValue(d1, d2);
                                        numericIntervalValue.add(value);
                                    } catch (NumberFormatException e) {
                                        System.out.println("\u001B[36m" + "C'est un StringIntervalValue");//cyan 
                                        value = new OSMTagStringIntervalValue(part[0], part[1]);
                                        stringIntervalValue.add(value);
                                    }
                                } else {
                                    System.out.println("\u001B[35m" + "C'est un StringSimpleValue");//PURPLE 
                                    value = new OSMTagStringSimpleValue(valeur);
                                    stringSimpleValue.add(value);
                                }
                            }

                        } else {
                            System.out.println("\u001B[31m" + "C'est un MultipleValue");//red 
                            value = new OSMTagMultipleValue(valeur);
                            multipleValue.add(value);
                        }
                    }

            }

        }
        System.out.println("les clefs simples sont:\n" + simpleKey);

        System.out.println("les clefs complexes sont:\n" + complexKey);

        System.out.println("les bolleanSimpleValue sont:\n" + bolleanSimpleValue);

        System.out.println("numericSimpleValue\n" + numericSimpleValue);

        System.out.println("numericIntervalValue\n" + numericIntervalValue);

        System.out.println("stringIntervalValue\n" + stringIntervalValue);

        System.out.println("stringSimpleValue\n" + stringSimpleValue);

        System.out.println("multipleValue\n" + multipleValue);

        System.out.println("dateSimpleValue\n" + dateSimpleValue);
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
        str.append(BoundingBoxGrenoble);
        str.append(";);out;");
        String wikiURL = str.toString();
        
        return wikiURL;
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
            System.out.println(date);

        } catch (ParseException e) {

            return false;
        }

        return true;
    }

}
