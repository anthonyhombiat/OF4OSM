/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author amehiris
 */
public class Tag {

    private String k;
    private String v;

    public Tag() {
    }

    public Tag(String k, String v) {
        this.v = v;
        this.k = k;
    }

    public String getV() {
        return v;
    }

    @XmlAttribute
    public void setV(String v) {
        this.v = v;
    }

    public String getK() {
        return k;
    }

    @XmlAttribute
    public void setK(String k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "Tag{" + " k=" + k + " , v=" + v + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.v != null ? this.v.hashCode() : 0);
        hash = 29 * hash + (this.k != null ? this.k.hashCode() : 0);
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
        final Tag other = (Tag) obj;
        if ((this.v == null) ? (other.v != null) : !this.v.equals(other.v)) {
            return false;
        }
        if ((this.k == null) ? (other.k != null) : !this.k.equals(other.k)) {
            return false;
        }
        return true;
    }

}
