/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author amehiris
 */
public class OSMAPIWay extends OSMAPIElement {

    private List<OSMAPINd> nds;

    public List<OSMAPINd> getNds() {
        return nds;
    }

    @XmlElement(name="nd")
    public void setNds(List<OSMAPINd> nds) {
        this.nds = nds;
    }

    @Override
    public String toString() {
        return "Way{" + "id=" + getId() + 
        		", timestamp=" + getTimestamp() + 
        		", uid=" + getUid() + 
        		", visible=" + getVisible() + 
        		", nd=" + nds + 
        		", tag=" + getTags() + 
        		", changeset=" + getChangeset() + 
        		", user=" + getUser() + 
        		", version=" + getVersion() + '}';
    }

    
}
