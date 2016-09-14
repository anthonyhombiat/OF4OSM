/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author amehiris
 */
public class OSMAPIWay {

    private String id;

    private String timestamp;

    private String uid;

    private String visible;

    private List<OSMAPINd> nd;

    private List<OSMAPITag> tag;

    private String changeset;

    private String user;

    private String version;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @XmlAttribute
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUid() {
        return uid;
    }

    @XmlAttribute
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVisible() {
        return visible;
    }

    @XmlAttribute
    public void setVisible(String visible) {
        this.visible = visible;
    }

    public List<OSMAPINd> getNd() {
        return nd;
    }

    @XmlElement (name="nd")
    public void setNd(List<OSMAPINd> nd) {
        this.nd = nd;
    }

    public List<OSMAPITag> getTag() {
        return tag;
    }

    @XmlElement (name="tag")
    public void setTag(List<OSMAPITag> tag) {
        this.tag = tag;
    }

    public String getChangeset() {
        return changeset;
    }

    @XmlAttribute
    public void setChangeset(String changeset) {
        this.changeset = changeset;
    }

    public String getUser() {
        return user;
    }

    @XmlAttribute
    public void setUser(String user) {
        this.user = user;
    }

    public String getVersion() {
        return version;
    }

    @XmlAttribute
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Way{" + "id=" + id + ", timestamp=" + timestamp + ", uid=" + uid + ", visible=" + visible + ", nd=" + nd + ", tag=" + tag + ", changeset=" + changeset + ", user=" + user + ", version=" + version + '}';
    }

    
}
