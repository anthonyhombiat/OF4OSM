package lig.steamer.of4osm.io;

import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.IOF4OSMOntology;
import lig.steamer.of4osm.PropLoader;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMCategoryTagKeyConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConcept;
import lig.steamer.of4osm.core.onto.meta.IOSMTagCombinationConceptParent;
import lig.steamer.of4osm.core.onto.meta.IOSMTagConceptParent;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.SimpleIRIMapper;
import org.semarglproject.vocab.OWL;

public class Onto2OWLWriter {

	private static final Logger LOGGER = Logger.getLogger(Onto2OWLWriter.class.getName());
	
	public static final IRI OF4OSM_IRI = IRI.create("http://steamer.imag.fr/of4osm");
	
	public static final String IRI_SEPARATOR = "#";
	
	public static final OWLOntologyManager ONTO_MANAGER = OWLManager.createOWLOntologyManager();
	public static final OWLDataFactory DATA_FACTORY = OWLManager.getOWLDataFactory();
	
	public static final OWLClass THING = DATA_FACTORY.getOWLClass(OWL.THING);
	public IRI outputIri;
	
	public Onto2OWLWriter(){
		
		PropLoader propLoader = new PropLoader();
		String filename = propLoader.getPath() + 
        		propLoader.getProp("outputDirPath") + 
        		propLoader.getProp("outputOntoFilename") + ".owl";
		
		outputIri = IRI.create(filename);
		
		SimpleIRIMapper mapper = new SimpleIRIMapper(OF4OSM_IRI, outputIri);
		ONTO_MANAGER.getIRIMappers().add(mapper);
	}
	
	public void write(IOF4OSMOntology of4osm){
		
		LOGGER.log(Level.INFO, "Writing the OF4OSM ontology to OWL file...");
		
		try {
			
			OWLOntology onto = ONTO_MANAGER.createOntology(OF4OSM_IRI);
			
			onto = parse(of4osm, onto);
			
			ONTO_MANAGER.saveOntology(onto, outputIri);
			
			ONTO_MANAGER.removeOntology(onto);
			
			LOGGER.log(Level.INFO, "Parsing the OF4OSM ontology to OWL file is done.");
			
		} catch (OWLOntologyCreationException e) {
			LOGGER.log(Level.SEVERE, "Parsing the OF4OSM ontology to OWL file has encounter a problem:");
			e.printStackTrace();
		} catch (OWLOntologyStorageException e) {
			LOGGER.log(Level.SEVERE, "Parsing the OF4OSM ontology to OWL file has encounter a problem:");
			e.printStackTrace();
		}
	}
	
	public OWLOntology parse(IOF4OSMOntology of4osm, OWLOntology onto){
		
		LOGGER.log(Level.INFO, "Parsing the OF4OSM ontology to OWL format...");
		
		onto = addOSMCategoryTagKeyConcepts(onto, of4osm);
		onto = addOSMCategoryTagConcepts(onto, of4osm);
		onto = addOSMTagCombinationConcepts(onto, of4osm);
		
		LOGGER.log(Level.INFO, "Parsing the OF4OSM ontology to OWL format is done.");
		
		return onto;
	}
	
	private static OWLOntology addOSMCategoryTagKeyConcepts(OWLOntology onto, IOF4OSMOntology of4osm){
		
		LOGGER.log(Level.INFO, "Adding OSMCategoryTagKeyConcepts...");
		
		for(IOSMCategoryTagKeyConcept concept : of4osm.getOSMCategoryTagKeyConcepts()){
			OWLClass clazz = DATA_FACTORY.getOWLClass(IRI.create(OF4OSM_IRI + IRI_SEPARATOR + concept.getLabels().get("EN"))); 
			OWLSubClassOfAxiom subClassOfAxiom = DATA_FACTORY.getOWLSubClassOfAxiom(clazz, THING);
			AddAxiom addAxiom = new AddAxiom(onto, subClassOfAxiom);
			ONTO_MANAGER.applyChange(addAxiom);
		}
		
		return onto;
	}
	
	private static OWLOntology addOSMCategoryTagConcepts(OWLOntology onto, IOF4OSMOntology of4osm){
		
		LOGGER.log(Level.INFO, "Adding OSMCategoryTagConcepts...");
		
		for(IOSMCategoryTagConcept concept : of4osm.getOSMCategoryTagConcepts()){
			
			OWLClass clazz = DATA_FACTORY.getOWLClass(IRI.create(OF4OSM_IRI + IRI_SEPARATOR + concept.getLabels().get("EN"))); 
			
			for(IOSMTagConceptParent parentConcept : concept.getParents()){
				OWLClass parentClazz = DATA_FACTORY.getOWLClass(IRI.create(OF4OSM_IRI + IRI_SEPARATOR + parentConcept.getLabels().get("EN"))); 
				OWLSubClassOfAxiom subClassOfAxiom = DATA_FACTORY.getOWLSubClassOfAxiom(clazz, parentClazz);
				AddAxiom addAxiom = new AddAxiom(onto, subClassOfAxiom);
				ONTO_MANAGER.applyChange(addAxiom);
			}
			
		}
		
		return onto;
	}
	
	private static OWLOntology addOSMTagCombinationConcepts(OWLOntology onto, IOF4OSMOntology of4osm){
		
		LOGGER.log(Level.INFO, "Adding OSMCategoryTagCombinationConcepts...");
		
		for(IOSMTagCombinationConcept concept : of4osm.getOSMTagCombinationConcepts()){
			
			OWLClass clazz = DATA_FACTORY.getOWLClass(IRI.create(OF4OSM_IRI + IRI_SEPARATOR + concept.getLabels().get("EN"))); 
			
			for(IOSMTagCombinationConceptParent parentConcept : concept.getParents()){
				OWLClass parentClazz = DATA_FACTORY.getOWLClass(IRI.create(OF4OSM_IRI + IRI_SEPARATOR + parentConcept.getLabels().get("EN"))); 
				OWLSubClassOfAxiom subClassOfAxiom = DATA_FACTORY.getOWLSubClassOfAxiom(clazz, parentClazz);
				AddAxiom addAxiom = new AddAxiom(onto, subClassOfAxiom);
				ONTO_MANAGER.applyChange(addAxiom);
			}
			
		}
		
		return onto;
	}
	
}
