/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amehiris
 */
@XmlRootElement
public class Osm {

    private Bounds bounds;
    private List<Node> node;
    private List<Relation> relation;
    private String generator;
    private List<Way> way;
    private String copyright;
    private String license;
    private String attribution;
    private String version;

    public Map<Tag, Integer> getTags() {

        Map<Tag, Integer> tags = new HashMap();

        for (Node node1 : this.node) {
            if (node1.getTag() != null) {
                if (tags.get(node1.getTag()) == null) {
                    tags.put(node1.getTag(), 1);
                } else {
                    int nbOccur = tags.get(node1.getTag());
                    tags.put(node1.getTag(), 1 + nbOccur);
                }
            }
        }

        for (Relation relation1 : this.relation) {
            if (relation1.getTag() != null) {
                List<Tag> tag = relation1.getTag();
                for (Tag tag1 : tag) {
                    if (tags.get(tag1) == null) {
                        tags.put(tag1, 1);
                    } else {
                        int nbOccur = tags.get(tag1);
                        tags.put(tag1, 1 + nbOccur);
                    }
                }
            }
        }

        for (Way way1 : this.way) {
            if (way1.getTag() != null) {
                List<Tag> tag = way1.getTag();
                for (Tag tag1 : tag) {
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

    public Bounds getBounds() {
        return bounds;
    }

    @XmlElement
    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public List<Node> getNode() {
        return node;
    }

    @XmlElement
    public void setNode(List<Node> node) {
        this.node = node;
    }

    public List<Relation> getRelation() {
        return relation;
    }

    @XmlElement
    public void setRelation(List<Relation> relation) {
        this.relation = relation;
    }

    public String getGenerator() {
        return generator;
    }

    @XmlAttribute
    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public List<Way> getWay() {
        return way;
    }

    @XmlElement
    public void setWay(List<Way> way) {
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
