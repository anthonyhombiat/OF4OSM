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
public class OSMAPIRelation extends OSMAPIElement {

    private List<OSMAPIMember> members;

    public List<OSMAPIMember> getMembers() {
        return members;
    }

    @XmlElement (name="member")
    public void setMembers(List<OSMAPIMember> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Relation{" + "id=" + getId() + 
        		", timestamp=" + getTimestamp() + 
        		", uid=" + getUid() + 
        		", member=" + members + 
        		", visible=" + getVisible() + 
        		", tag=" + getTags() + 
        		", changeset=" + getChangeset() + 
        		", user=" + getUser() + 
        		", version=" + getVersion() + '}';
    }

}
