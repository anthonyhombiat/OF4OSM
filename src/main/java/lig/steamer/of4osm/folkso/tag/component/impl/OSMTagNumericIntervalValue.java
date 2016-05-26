package lig.steamer.of4osm.folkso.tag.component.impl;

import lig.steamer.of4osm.folkso.tag.component.IOSMTagNumericIntervalValue;

/**
 * 
 */
public class OSMTagNumericIntervalValue extends OSMTagValue implements IOSMTagNumericIntervalValue {


    /**
     * 
     */
    public Double binf;

    /**
     * 
     */
    public Double bsup;

    public OSMTagNumericIntervalValue(Double binf, Double bsup) {
        this.binf = binf;
        this.bsup = bsup;
    }

    @Override
    public String toString() {
        return "{" + "binf=" + binf + ", bsup=" + bsup + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final OSMTagNumericIntervalValue other = (OSMTagNumericIntervalValue) obj;
        if (this.binf != other.binf && (this.binf == null || !this.binf.equals(other.binf))) {
            return false;
        }
        if (this.bsup != other.bsup && (this.bsup == null || !this.bsup.equals(other.bsup))) {
            return false;
        }
        return true;
    }

    
    /**
     * @return
     */
    public Double getBinf() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Double getBsup() {
        // TODO implement here
        return null;
    }

}