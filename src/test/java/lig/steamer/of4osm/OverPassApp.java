/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagComplexKey;

import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagDateValue;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagMultipleValue;

import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagNumericValue;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagSimpleKey;

import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagValue;

import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMComplexKeyStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMMultipleValueCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleBooleanPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleDatePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleNumericPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMSimpleStringPropertyTag;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMTag;
import lig.steamer.of4osm.ws.overPass.Element;
import lig.steamer.of4osm.ws.overPass.OverPass;
import lig.steamer.of4osm.ws.tagInfo.TagInfo;
import lig.steamer.of4osm.ws.tagInfo.TagsPopularData;
import lig.steamer.of4osm.ws.tagInfo.TagsPopularHead;

/**
 *
 * @author amehiris
 */
public class OverPassApp {

    public static void main(String[] args) throws MalformedURLException, IOException {

        //Category 
        Set simpleCategoryTag = new HashSet(); // OSMSimpleCategoryTag
        Set multipleValueCategoryTag = new HashSet(); //OSMMultipleValueCategoryTag

        //Property
        Set multipleValuePropertyTag = new HashSet();    //OSMMultipleValuePropertyTag

        Set simpleBooleanPropertyTag = new HashSet();    //OSMSimpleBooleanPropertyTag
        Set complexKeyBooleanPropertyTag = new HashSet();    //OSMComplexKeyBooleanPropertyTag

        Set simpleStringPropertyTag = new HashSet();    //OSMSimpleStringPropertyTag
        Set complexKeyStringPropertyTag = new HashSet();    //OSMComplexKeyStringPropertyTag

        Set simpleNumericPropertyTag = new HashSet();    //OSMSimpleNumericPropertyTag
        Set complexKeyNumericPropertyTag = new HashSet();    //OSMComplexKeyNumericPropertyTag

        Set simpleDatePropertyTag = new HashSet();   //OSMSimpleDatePropertyTag
        Set complexKeyDatePropertyTag = new HashSet();   //OSMComplexKeyDatePropertyTag

        String bBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
        String bBoxGrenobleCentre = "(45.1873363,5.7180328,45.188529,5.724524)";
        String bBoxParis = "(48.658291,2.08679,49.04694,2.63791)";

        TagInfo tagInfo = new TagInfo();
        TagsPopularHead tagsPopularHead = tagInfo.tagsPopular(1,10);
        List<TagsPopularData> dataPopularTags = tagsPopularHead.getData();
        for (TagsPopularData popularTags : dataPopularTags) {
            if (popularTags.isIn_wiki()) {
                OverPass overPasse = new OverPass(bBoxGrenobleCentre, "node", popularTags.getKey(), popularTags.getValue());

                //System.out.println(overPasse.getHeadResult().toString());
                //parcourir la liste d'element 
                List<Element> elements = overPasse.getHeadResult().getElements();
                for (int i = 0; i < elements.size(); i++) {

                    //parcourir la map tags  
                    Map tags = elements.get(i).getTags();
                    Iterator j = tags.keySet().iterator();

                    while (j.hasNext()) {
                        //traitement de type de tags
                        String clef = (String) j.next();
                        String valeur = (String) tags.get(clef);

                        OSMTagKey key = stringToKey(clef, overPasse.getWikiURL());
                        OSMTagValue value = stringToValue(valeur);

                        OSMTag type;
                        if (OSMTagSimpleKey.class.isInstance(key)) {

                            if (OSMTagMultipleValue.class.isInstance(value)) {
                                //attention faut voir est-ce que Category ou Property 
                                if (isProperty(clef)) {

                                    type = new OSMMultipleValuePropertyTag((OSMTagSimpleKey) key, (OSMTagMultipleValue) value);
                                    multipleValuePropertyTag.add(type);
                                } else {
                                    type = new OSMMultipleValueCategoryTag((OSMTagSimpleKey) key, (OSMTagMultipleValue) value);
                                    multipleValueCategoryTag.add(type);

                                }
                            }
                            if (OSMTagBooleanValue.class.isInstance(value)) {
                                type = new OSMSimpleBooleanPropertyTag((OSMTagSimpleKey) key, (OSMTagBooleanValue) value);
                                simpleBooleanPropertyTag.add(type);
                            }

                            if (OSMTagStringValue.class.isInstance(value)) {
                                //attention Category or Property traiter apres inchAllah
                                if (isProperty(clef)) {
                                    type = new OSMSimpleStringPropertyTag((OSMTagSimpleKey) key, (OSMTagStringValue) value);
                                    simpleStringPropertyTag.add(type);
                                } else {

                                    type = new OSMSimpleCategoryTag((OSMTagSimpleKey) key, (OSMTagStringValue) value);
                                    simpleCategoryTag.add(type);
                                }
                            }

                            if (OSMTagNumericValue.class.isInstance(value)) {
                                type = new OSMSimpleNumericPropertyTag((OSMTagSimpleKey) key, (OSMTagNumericValue) value);
                                simpleNumericPropertyTag.add(type);
                            }

                            if (OSMTagDateValue.class.isInstance(value)) {
                                type = new OSMSimpleDatePropertyTag((OSMTagSimpleKey) key, (OSMTagDateValue) value);
                                simpleDatePropertyTag.add(type);
                            }

                        }
                        if (OSMTagComplexKey.class.isInstance(key)) {

                            if (OSMTagBooleanValue.class.isInstance(value)) {
                                type = new OSMComplexKeyBooleanPropertyTag((OSMTagComplexKey) key, (OSMTagBooleanValue) value);
                                complexKeyBooleanPropertyTag.add(type);
                            }

                            if (OSMTagStringValue.class.isInstance(value)) {
                                type = new OSMComplexKeyStringPropertyTag((OSMTagComplexKey) key, (OSMTagStringValue) value);
                                complexKeyStringPropertyTag.add(type);
                            }
                            if (OSMTagNumericValue.class.isInstance(value)) {
                                type = new OSMComplexKeyNumericPropertyTag((OSMTagComplexKey) key, (OSMTagNumericValue) value);
                                complexKeyNumericPropertyTag.add(type);
                            }

                            if (OSMTagDateValue.class.isInstance(value)) {
                                type = new OSMComplexKeyDatePropertyTag((OSMTagComplexKey) key, (OSMTagDateValue) value);
                                complexKeyDatePropertyTag.add(type);
                            }

                        }
                    }
                }

            }
        }
        System.out.println("\u001B[32m" + "multipleValueCategoryTag\t" + "\u001B[34m" + "size=" + multipleValueCategoryTag.size() + "\n" + multipleValueCategoryTag);

        System.out.println("\u001B[32m" + "simpleCategoryTag\t" + "\u001B[34m" + "size=" + simpleCategoryTag.size() + "\n" + simpleCategoryTag);
        System.out.println("\u001B[35m"+"Simple Key:");
        System.out.println("\u001B[32m" + "multipleValuePropertyTag\t" + "\u001B[34m" + "size=" + multipleValuePropertyTag.size() + "\n" + multipleValuePropertyTag);

        System.out.println("\u001B[32m" + "simpleBooleanPropertyTag\t" + "\u001B[34m" + "size=" + simpleBooleanPropertyTag.size() + "\n" + simpleBooleanPropertyTag);

        System.out.println("\u001B[32m" + "simpleStringPropertyTag\t" + "\u001B[34m" + "size=" + simpleStringPropertyTag.size() + "\n" + simpleStringPropertyTag);
        System.out.println("\u001B[32m" + "simpleNumericPropertyTag\t" + "\u001B[34m" + "size=" + simpleNumericPropertyTag.size() + "\n" + simpleNumericPropertyTag);

        System.out.println("\u001B[32m" + "simpleDatePropertyTag\t" + "\u001B[34m" + "size=" + simpleDatePropertyTag.size() + "\n" + simpleDatePropertyTag);

        System.out.println("\u001B[35m"+"Complex Key:");
        System.out.println("\u001B[32m" + "complexKeyBooleanPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyBooleanPropertyTag.size() + "\n" + complexKeyBooleanPropertyTag);

        System.out.println("\u001B[32m" + "complexKeyStringPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyStringPropertyTag.size() + "\n" + complexKeyStringPropertyTag);
        System.out.println("\u001B[32m" + "complexKeyNumericPropertyTag\t" + "\u001B[34m" + "size=" + complexKeyNumericPropertyTag.size() + "\n" + complexKeyNumericPropertyTag);

        System.out.println("\u001B[32m" + "complexKeyDatePropertyTag\t" + "\u001B[34m" + "size=" + complexKeyDatePropertyTag.size() + "\n" + complexKeyDatePropertyTag);

    }

    public static boolean isProperty(String clef) {

        //from additional properties
        String[] categorys = {"addr",
            "attribution", "comment", "description", "email", "fax", "fixme", "image", "note", "phone",
            "source", "source_ref", "url", "todo", "website", "wikipedia",
            "int_name", "loc_name", "nat_name", "official_name", "old_name", "reg_name", "short_name",
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
        while (i < categorys.length && !categorys[i].equals(clef)) {
            for (String category : categorys) {
                i++;
            }
        }
        return i != (categorys.length);
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
        return value;
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
