package lig.steamer.of4osm.ws.osmapi;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author amehiris
 */
public class OSMAPIMember {
   
	private String ref;
    private String role;
    private String type;

    public String getRef() {
        return ref;
    }

    @XmlAttribute
    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRole() {
        return role;
    }

    @XmlAttribute
    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }
    
    @XmlAttribute
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Member{" + "ref=" + ref + ", role=" + role + ", type=" + type + '}';
    }
    
}
