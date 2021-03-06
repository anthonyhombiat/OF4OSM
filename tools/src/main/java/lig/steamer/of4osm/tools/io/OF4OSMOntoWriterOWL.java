package lig.steamer.of4osm.tools.io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import lig.steamer.of4osm.tools.PropLoader;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IConcept;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.FileDocumentTarget;
import org.semanticweb.owlapi.io.OWLOntologyDocumentTarget;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.util.SimpleIRIMapper;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;
import org.semarglproject.vocab.OWL;

public class OF4OSMOntoWriterOWL {

	private static final Logger LOGGER = Logger.getLogger(OF4OSMOntoWriterOWL.class.getName());
	
	public static final IRI OF4OSM_IRI = IRI.create("http://steamer.imag.fr/of4osm");
	
	public static final String IRI_SEPARATOR = "#";
	
	public static final OWLOntologyManager ONTO_MANAGER = OWLManager.createOWLOntologyManager();
	public static final OWLDataFactory DATA_FACTORY = OWLManager.getOWLDataFactory();
	
	public static final OWLClass THING = DATA_FACTORY.getOWLClass(OWL.THING);
	
	public OF4OSMOntoWriterOWL(){

	}
	
	@SuppressWarnings("deprecation")
	public void write(IOF4OSMOntology of4osm, IRI file){
		
		final long t0 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Writing the OF4OSM ontology to OWL file...");
		
		SimpleIRIMapper mapper = new SimpleIRIMapper(OF4OSM_IRI, file);
		ONTO_MANAGER.getIRIMappers().add(mapper);
		
		try {
			OWLOntology onto = ONTO_MANAGER.createOntology(OF4OSM_IRI);
			
			onto = parse(of4osm, onto);
			
			OWLOntologyDocumentTarget document = new FileDocumentTarget(new File(file.getShortForm()));
			
			ONTO_MANAGER.saveOntology(onto, document);
			
			LOGGER.log(Level.INFO, "Nb of owl:class added to the OF4OSM ontology: " + onto.getClassesInSignature().size());
			
			ONTO_MANAGER.removeOntology(onto);
			
			final long t1 = System.currentTimeMillis();
			LOGGER.log(Level.INFO, "Parsing the OF4OSM ontology to OWL file is done (" + DurationFormatUtils.formatDurationHMS(t1 - t0) + ").");
			LOGGER.log(Level.INFO, "Ontology stored in the file " + document.getDocumentIRI().get().getShortForm());
		} catch (OWLOntologyCreationException e) {
			LOGGER.log(Level.SEVERE, "Parsing the OF4OSM ontology to OWL file has encounter a problem:");
			e.printStackTrace();
		} catch (OWLOntologyStorageException e) {
			LOGGER.log(Level.SEVERE, "Parsing the OF4OSM ontology to OWL file has encounter a problem:");
			e.printStackTrace();
		}
	}

	public void write(IOF4OSMOntology of4osm, String outputDir, String outputFilename){
		write(of4osm, IRI.create(outputDir + outputFilename + ".owl"));
	}
	
	public void write(IOF4OSMOntology of4osm, String outputDir){
		String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		PropLoader propLoader = new PropLoader();
		String outputFilename = propLoader.getProp("outputOntoFilename") + now;
		write(of4osm, outputDir, outputFilename);
	}
	
	public void write(IOF4OSMOntology of4osm){
		PropLoader propLoader = new PropLoader();
		String outputDir = propLoader.getPath() + propLoader.getProp("outputDirPath");
		write(of4osm, outputDir);
	}
	
	public OWLOntology parse(IOF4OSMOntology of4osm, OWLOntology onto){
		
		LOGGER.log(Level.INFO, "Parsing the OF4OSM ontology to OWL format...");
		
		onto = addConcepts(onto, of4osm.getConcepts());
		
		LOGGER.log(Level.INFO, "Parsing the OF4OSM ontology to OWL format is done.");
		
		return onto;
	}
	
	private static OWLOntology addConcepts(OWLOntology onto, Collection<IConcept> concepts){
		
		LOGGER.log(Level.INFO, "Adding Concepts...");
		
		for(IConcept concept : concepts){
			
			LOGGER.log(Level.INFO, concept.getIRI().toString());
			
			OWLClass clazz = DATA_FACTORY.getOWLClass(concept.getIRI()); 
			OWLAxiom declarationAxiom = DATA_FACTORY.getOWLDeclarationAxiom(clazz);
			ONTO_MANAGER.applyChange(new AddAxiom(onto, declarationAxiom));
			
			for(Entry<String, String> entry : concept.getLabels().entrySet()){
				OWLAnnotationProperty labelProp = DATA_FACTORY.getOWLAnnotationProperty(OWLRDFVocabulary.RDFS_LABEL.getIRI());
				OWLLiteral label = DATA_FACTORY.getOWLLiteral(entry.getValue(), entry.getKey());
				OWLAnnotation labelAnnot = DATA_FACTORY.getOWLAnnotation(labelProp,	label);
				OWLAnnotationAssertionAxiom labelAxiom = DATA_FACTORY.getOWLAnnotationAssertionAxiom(
						labelProp, clazz.getIRI(), labelAnnot.getValue());
				ONTO_MANAGER.applyChange(new AddAxiom(onto, labelAxiom));
			}
			
			for(IConcept parentConcept : concept.getParents()){
				OWLClass parentClazz = DATA_FACTORY.getOWLClass(parentConcept.getIRI()); 
				OWLSubClassOfAxiom subClassOfAxiom2 = DATA_FACTORY.getOWLSubClassOfAxiom(clazz, parentClazz);
				AddAxiom addAxiom2 = new AddAxiom(onto, subClassOfAxiom2);
				ONTO_MANAGER.applyChange(addAxiom2);
			}
		}
		
		return onto;
	}
	
}
