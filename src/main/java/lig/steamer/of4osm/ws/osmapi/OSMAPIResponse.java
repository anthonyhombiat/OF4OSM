/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amehiris
 */

@XmlRootElement(name="osm")
public class OSMAPIResponse {

    private OSMAPIBounds bounds;
    private List<OSMAPINode> node;
    private List<OSMAPIRelation> relation;
    private String generator;
    private List<OSMAPIWay> way;
    private String copyright;
    private String license;
    private String attribution;
    private String version;

    public Map<OSMAPITag, Integer> getTags() {

        Map<OSMAPITag, Integer> tags = new HashMap();

        for (OSMAPINode node1 : this.node) {
            if (node1.getTag() != null) {
                if (tags.get(node1.getTag()) == null) {
                    tags.put(node1.getTag(), 1);
                } else {
                    int nbOccur = tags.get(node1.getTag());
                    tags.put(node1.getTag(), 1 + nbOccur);
                }
            }
        }

        for (OSMAPIRelation relation1 : this.relation) {
            if (relation1.getTag() != null) {
                List<OSMAPITag> tag = relation1.getTag();
                for (OSMAPITag tag1 : tag) {
                    if (tags.get(tag1) == null) {
                        tags.put(tag1, 1);
                    } else {
                        int nbOccur = tags.get(tag1);
                        tags.put(tag1, 1 + nbOccur);
                    }
                }
            }
        }

        for (OSMAPIWay way1 : this.way) {
            if (way1.getTag() != null) {
                List<OSMAPITag> tag = way1.getTag();
                for (OSMAPITag tag1 : tag) {
                    if (tags.get(tag1) == null) {
                        tags.put(tag1, 1);
                    } else {
                        int nbOccur = tags.get(tag1);
                        tags.put(tag1, 1 + nbOccur);
                    }
                }
            }
        }

        return tags;
    }

    public OSMAPIBounds getBounds() {
        return bounds;
    }

    @XmlElement (name="bounds")
    public void setBounds(OSMAPIBounds bounds) {
        this.bounds = bounds;
    }

    public List<OSMAPINode> getNode() {
        return node;
    }

    @XmlElement (name="node")
    public void setNode(List<OSMAPINode> node) {
        this.node = node;
    }

    public List<OSMAPIRelation> getRelation() {
        return relation;
    }

    @XmlElement (name="relation")
    public void setRelation(List<OSMAPIRelation> relation) {
        this.relation = relation;
    }

    public String getGenerator() {
        return generator;
    }

    @XmlAttribute
    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public List<OSMAPIWay> getWay() {
        return way;
    }

    @XmlElement (name="way")
    public void setWay(List<OSMAPIWay> way) {
        this.way = way;
    }

    public String getCopyright() {
        return copyright;
    }

    @XmlAttribute
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getLicense() {
        return license;
    }

    @XmlAttribute
    public void setLicense(String license) {
        this.license = license;
    }

    public String getAttribution() {
        return attribution;
    }

    @XmlAttribute
    public void setAttribution(String attribution) {
        this.attribution = attribution;
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
        return "Osm{" + "bounds=" + bounds + ", node=" + node + ", relation=" + relation + ", generator=" + generator + ", way=" + way + ", copyright=" + copyright + ", license=" + license + ", attribution=" + attribution + ", version=" + version + '}';
    }

}
