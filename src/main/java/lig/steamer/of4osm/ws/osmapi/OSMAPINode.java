/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author amehiris
 */
public class OSMAPINode {

    private String id;
    private String timestamp;
    private String uid;
    private String lon;
    private String visible;
    private OSMAPITag tag;
    private String changeset;
    private String user;
    private String lat;
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

    public String getLon() {
        return lon;
    }

    @XmlAttribute
    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getVisible() {
        return visible;
    }

    @XmlAttribute
    public void setVisible(String visible) {
        this.visible = visible;
    }

    public OSMAPITag getTag() {
        return tag;
    }

    @XmlElement (name="tag")
    public void setTag(OSMAPITag tag) {
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

    public String getLat() {
        return lat;
    }

    @XmlAttribute
    public void setLat(String lat) {
        this.lat = lat;
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
        return "Node{" + "id=" + id + ", timestamp=" + timestamp + ", uid=" + uid + ", lon=" + lon + ", visible=" + visible + ", tag=" + tag + ", changeset=" + changeset + ", user=" + user + ", lat=" + lat + ", version=" + version + '}';
    }

}
