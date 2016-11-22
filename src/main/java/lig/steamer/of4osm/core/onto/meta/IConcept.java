package lig.steamer.of4osm.core.onto.meta;

import java.util.Map;
import java.util.Set;

import org.semanticweb.owlapi.model.IRI;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IConcept {

	/**
     * 
     * @return
     */
    public IRI getIRI();
	
    /**
     * @return
     */
    public Map<String, String> getLabels();

    /**
     * 
     */
    public void addLabel(String lang, String label);
    
    /**
     * @return
     */
    public String getDefaultLabel();
    
    /**
     * @return
     */
    public Set<? extends IConcept> getParents();

}