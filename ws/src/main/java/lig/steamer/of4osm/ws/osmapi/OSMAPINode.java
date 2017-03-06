package lig.steamer.of4osm.ws.osmapi;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author amehiris
 */
public class OSMAPINode extends OSMAPIElement {

    private String lon;
    private String lat;

    public String getLon() {
        return lon;
    }

    @XmlAttribute
    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    @XmlAttribute
    public void setLat(String lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + getId() + 
        		", timestamp=" + getTimestamp() + 
        		", uid=" + getUid() + 
        		", lon=" + lon + 
        		", visible=" + getVisible() + 
        		", tags=" + getTags() + 
        		", changeset=" + getChangeset() + 
        		", user=" + getUser() + 
        		", lat=" + lat + 
        		", version=" + getVersion() + '}';
    }

}
