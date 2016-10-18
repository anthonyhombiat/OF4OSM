package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.model.IRI;

import lig.steamer.of4osm.core.onto.meta.IConcept;

/**
 *
 */
public abstract class Concept implements IConcept {

    public static final IRI OF4OSM_IRI = IRI.create("http://steamer.imag.fr/of4osm");
	
	public IRI iri;
	public Map<String, String> labels;

    public Concept(String label) {
        this.labels = new HashMap<>();
        setDefaultLabel(label);
    }

    @Override
    public Map<String, String> getLabels() {
        return labels;
    }

    public void addLabel(String lang, String label) {
        labels.put(lang, label);
    }
 
    @Override
    public String getDefaultLabel() {
        return labels.get("EN");
    }
    
    @Override
    public void setDefaultLabel(String label){
    	labels.put("EN", label);
    }
    
    @Override
    public abstract Set<? extends IConcept> getParents();
    
    @Override
    public IRI getIRI(){
    	return IRI.create(OF4OSM_IRI + "#" + getDefaultLabel());
    }
    
    @Override
    public boolean equals(Object object){
    	if(object instanceof IConcept)
    		return ((IConcept) object).getIRI().equals(iri);
    	return false;
    }

}
