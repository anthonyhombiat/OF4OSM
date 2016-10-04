/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.ArrayList;
import java.util.List;

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
    private List<OSMAPINode> nodes;
    private List<OSMAPIWay> ways;
    private List<OSMAPIRelation> relations;
    private String generator;
    private String copyright;
    private String license;
    private String attribution;
    private String version;

    public OSMAPIBounds getBounds() {
        return bounds;
    }

    @XmlElement (name="bounds")
    public void setBounds(OSMAPIBounds bounds) {
        this.bounds = bounds;
    }

    public List<OSMAPINode> getNodes() {
        return nodes;
    }

    @XmlElement (name="node")
    public void setNodes(List<OSMAPINode> nodes) {
        this.nodes = nodes;
    }

    public List<OSMAPIRelation> getRelations() {
        return relations;
    }

    @XmlElement (name="relation")
    public void setRelations(List<OSMAPIRelation> relations) {
        this.relations = relations;
    }

    public String getGenerator() {
        return generator;
    }

    @XmlAttribute
    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public List<OSMAPIWay> getWays() {
        return ways;
    }

    @XmlElement (name="way")
    public void setWays(List<OSMAPIWay> ways) {
        this.ways = ways;
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
    
    public List<OSMAPIElement> getElements(){
    	List<OSMAPIElement> elements = new ArrayList<OSMAPIElement>();
    	elements.addAll(nodes);
    	elements.addAll(ways);
    	elements.addAll(relations);
    	return elements;
    }

    @Override
    public String toString() {
        return "Osm{" + "bounds=" + bounds + 
        		", node=" + nodes + 
        		", relation=" + relations + 
        		", generator=" + generator + 
        		", way=" + ways + 
        		", copyright=" + copyright + 
        		", license=" + license + 
        		", attribution=" + attribution + 
        		", version=" + version + '}';
    }

}
