package lig.steamer.of4osm.ws.osmapi;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author amehiris
 */
public class OSMAPINd {

    private String ref;

    public String getRef() {
        return ref;
    }

    @XmlAttribute
    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Nd{" + "ref=" + ref + '}';
    }

}
