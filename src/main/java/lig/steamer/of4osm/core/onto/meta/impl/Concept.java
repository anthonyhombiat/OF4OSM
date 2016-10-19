package lig.steamer.of4osm.core.onto.meta.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lig.steamer.of4osm.core.onto.meta.IConcept;

import org.semanticweb.owlapi.model.IRI;

/**
 *
 */
public abstract class Concept implements IConcept {

    public static final IRI OF4OSM_IRI = IRI.create("http://steamer.imag.fr/of4osm");
	
	public IRI iri;
	public Map<String, String> labels;

    public Concept(String label) {
        labels = new HashMap<>();
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
    	iri = IRI.create(OF4OSM_IRI + "#" + label);
    }
    
    @Override
    public abstract Set<? extends IConcept> getParents();
    
    @Override
    public IRI getIRI(){
    	return iri;
    }
    
    @Override
   	public int hashCode() {
   		final int prime = 31;
   		int result = 1;
   		result = prime * result + ((iri == null) ? 0 : iri.hashCode());
   		return result;
   	}

   	@Override
   	public boolean equals(Object obj) {
   		
   		if (this == obj)
   			return true;
   		
   		if (obj == null)
   			return false;
   		
   		if (getClass() != obj.getClass())
   			return false;
   		
   		Concept other = (Concept) obj;
   		
   		if (iri == null) {
   			if (other.iri != null)
   				return false;
   		} else if (!iri.equals(other.iri))
   			return false;
   		
   		return true;
   	}

}
