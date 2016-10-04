package lig.steamer.of4osm;

import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.io.Onto2OWLWriter;
import lig.steamer.of4osm.parse.Folkso2OntoParser;
import lig.steamer.of4osm.parse.OSMAPI2FolksoParser;
import lig.steamer.of4osm.ws.osmapi.OSMAPIClient;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        IOF4OSMOntology of4osm = new OF4OSMOntology();
        
        // Grenoble centre 
        OSMAPIRequest req = new OSMAPIRequest("5.7180328", "45.1873363", "5.724524", "45.188529");
        
        // Grenoble 
//        OSMAPIRequest req = new OSMAPIRequest("5.712204", "45.178649", "5.727654", "45.189538");
        
        OSMAPIClient client = new OSMAPIClient();
        OSMAPIResponse resp = client.send(req);
        
        IOF4OSMFolksonomy folkso = OSMAPI2FolksoParser.parse(resp);

//        Folkso2CSVWriter.write(folkso);

        of4osm = Folkso2OntoParser.addConceptsFromFolkso(of4osm, folkso);
        
        Onto2OWLWriter ontoParser = new Onto2OWLWriter();
        ontoParser.write(of4osm);

    }

}
