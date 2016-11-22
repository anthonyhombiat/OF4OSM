package lig.steamer.of4osm.io;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.DurationFormatUtils;

import lig.steamer.of4osm.core.folkso.tag.key.impl.LifecycleState;
import lig.steamer.of4osm.core.onto.IOF4OSMOntology;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConcept;
import lig.steamer.of4osm.core.onto.meta.IHighLevelConceptParent;
import lig.steamer.of4osm.util.OF4OSMConceptFactory;

public final class OF4OSMOntoReaderLifecycleStates {

	private static final Logger LOGGER = Logger.getLogger(OF4OSMOntoReaderLifecycleStates.class.getName());
	
	public static void read(LifecycleState[] states, IOF4OSMOntology of4osm){
		
		final long t0 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Adding lifecycle states to of4osm...");
		
		IHighLevelConcept statefulConcept = OF4OSMConceptFactory.createHighLevelConcept("StatefulEntity");
		
		for(LifecycleState state : states){
			IHighLevelConcept concept = OF4OSMConceptFactory.createHighLevelConcept(state.name() + "Entity");
			concept.addParent((IHighLevelConceptParent) statefulConcept);
			of4osm.addConcept(concept);
		}
		
		final long t1 = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Adding lifecycle states done (" + DurationFormatUtils.formatDurationHMS(t1 - t0) + ").");
	}
	
}
