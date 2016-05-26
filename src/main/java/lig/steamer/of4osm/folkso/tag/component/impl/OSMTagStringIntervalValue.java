package lig.steamer.of4osm.folkso.tag.component.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagStringIntervalValue;

/**
 * 
 */
public class OSMTagStringIntervalValue extends OSMTagValue implements IOSMTagStringIntervalValue {

   
    /**
     * 
     */
    public String binf;

    /**
     * 
     */
    public String bsup;

    public OSMTagStringIntervalValue(String binf, String bsup) {
        this.binf = binf;
        this.bsup = bsup;
    }

    @Override
    public String toString() {
        return "{" + "binf=" + binf + ", bsup=" + bsup + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.binf != null ? this.binf.hashCode() : 0);
        hash = 41 * hash + (this.bsup != null ? this.bsup.hashCode() : 0);
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
        final OSMTagStringIntervalValue other = (OSMTagStringIntervalValue) obj;
        if ((this.binf == null) ? (other.binf != null) : !this.binf.equals(other.binf)) {
            return false;
        }
        if ((this.bsup == null) ? (other.bsup != null) : !this.bsup.equals(other.bsup)) {
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    public String getBinf() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getBsup() {
        // TODO implement here
        return "";
    }

}