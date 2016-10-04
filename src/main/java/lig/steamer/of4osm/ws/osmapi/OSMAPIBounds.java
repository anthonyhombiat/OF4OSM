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
public class OSMAPIBounds {

    private String minlat;
    private String maxlat;
    private String maxlon;
    private String minlon;

    public String getMinlat() {
        return minlat;
    }

    @XmlAttribute
    public void setMinlat(String minlat) {
        this.minlat = minlat;
    }

    public String getMaxlat() {
        return maxlat;
    }

    @XmlAttribute
    public void setMaxlat(String maxlat) {
        this.maxlat = maxlat;
    }

    public String getMaxlon() {
        return maxlon;
    }

    @XmlAttribute
    public void setMaxlon(String maxlon) {
        this.maxlon = maxlon;
    }

    public String getMinlon() {
        return minlon;
    }

    @XmlAttribute
    public void setMinlon(String minlon) {
        this.minlon = minlon;
    }

    @Override
    public String toString() {
        return "Bounds{" + "minlat=" + minlat + 
        		", maxlat=" + maxlat + 
        		", maxlon=" + maxlon + 
        		", minlon=" + minlon + '}';
    }

}
