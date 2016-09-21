/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm;

import lig.steamer.of4osm.core.onto.meta.IConcept;

/**
 *
 * @author amehiris
 */
public interface IOF4OSMOntology {
    
    public void addConcept(IConcept concept, int nbInstances);
    public void afficher();
    
}
