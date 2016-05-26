package lig.steamer.of4osm.folkso.tag.component.impl;

import java.util.Date;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagDateIntervalValue;

/**
 * 
 */
public class OSMTagDateIntervalValue extends OSMTagValue implements IOSMTagDateIntervalValue {

   
    /**
     * 
     */
    public Date binf;

    /**
     * 
     */
    public Date bsup;

    public OSMTagDateIntervalValue(String valeur) {

        this.binf = stringToDate(valeur.substring(0,valeur.length()));
        this.bsup = stringToDate(valeur.substring(valeur.length()/2,valeur.length()));
    }

    public Date getBinf() {
        return binf;
    }

    public Date getBsup() {
        return bsup;
    }

    @Override
    public String toString() {
        return "OSMTagDateIntervalValue{" + "binf=" + binf + ", bsup=" + bsup + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.binf != null ? this.binf.hashCode() : 0);
        hash = 83 * hash + (this.bsup != null ? this.bsup.hashCode() : 0);
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
        final OSMTagDateIntervalValue other = (OSMTagDateIntervalValue) obj;
        if (this.binf != other.binf && (this.binf == null || !this.binf.equals(other.binf))) {
            return false;
        }
        if (this.bsup != other.bsup && (this.bsup == null || !this.bsup.equals(other.bsup))) {
            return false;
        }
        return true;
    }



}