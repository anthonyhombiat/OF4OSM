package lig.steamer.of4osm.core.folkso.tag.value.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;

/**
 *
 */
public class OSMTagDateValue extends OSMTagValue implements IOSMTagDateValue {

    /**
     *
     */
    public Date value;

    public OSMTagDateValue(String value) {

        Date date = null;
        if (value == null) {

            date = null;
        } else {

            String[] dateFormats = {"yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM/dd", "dd MMM yyyy", "yyyy-MM-dd"};
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
        this.value = date;
        this.labels = new HashSet<String>();
        this.labels.add(value);
    }

    public Date getValue() {
        return value;
    }

    @Override
    public String toString() {
        return labels + ";" + value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OSMTagDateValue other = (OSMTagDateValue) obj;
        if (this.value != other.value && (this.value == null || !this.value.equals(other.value))) {
            return false;
        }
        return true;
    }

}
