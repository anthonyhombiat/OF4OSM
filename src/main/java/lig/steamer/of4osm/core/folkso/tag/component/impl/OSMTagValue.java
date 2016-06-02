package lig.steamer.of4osm.core.folkso.tag.component.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import lig.steamer.of4osm.core.folkso.tag.component.IOSMTagValue;

/**
 * 
 */
public abstract class OSMTagValue implements IOSMTagValue {

    /**
     * Default constructor
     */
    public OSMTagValue() {
    }

    /**
     * 
     */
    public Set<String> labels;


    /**
     * @return
     */
    public Set<String> getLabels() {
        // TODO implement here
        return null;
    }

    public Date stringToDate(String value) {
        Date date = null;
        if (value == null) {

            date = null;
        } else {

            String[] dateFormats = {"yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM/dd", "dd MMM yyyy"};
            int i = 0;
            while (date == null && i < dateFormats.length) {
                try {
                    String dateFromat = dateFormats[i];
                    SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
                    sdf.setLenient(false);
                    //if not valid, it will throw ParseException
                    date = sdf.parse(value);

                } catch (ParseException e) {
                    date = null;
                }
                i++;
            }
        }
    return date;
    }
}