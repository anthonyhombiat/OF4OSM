/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overpass;

import java.util.Objects;

/**
 *
 * @author amehiris
 */
public class OverpassTag {
    
    
    private String k;
    private String v;

    public OverpassTag() {
    }

    public OverpassTag(String k, String v) {
        this.k = k;
        this.v = v;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.k);
        hash = 61 * hash + Objects.hashCode(this.v);
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
        final OverpassTag other = (OverpassTag) obj;
        if (!Objects.equals(this.k, other.k)) {
            return false;
        }
        if (!Objects.equals(this.v, other.v)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OverpassTag{" + "k=" + k + ", v=" + v + '}';
    }
    
    
}
