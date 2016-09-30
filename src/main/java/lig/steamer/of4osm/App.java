package lig.steamer.of4osm;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.util.Folkso2CSVParser;
import lig.steamer.of4osm.util.Folkso2OntoParser;
import lig.steamer.of4osm.util.OSMAPI2FolksoParser;
import lig.steamer.of4osm.ws.osmapi.OSMAPIClient;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRequest;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;
import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws MalformedURLException, IOException, Exception {

        IOF4OSMOntology onto = new OF4OSMOntology();

//        String bBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
//        
//        OverPassRequest req = new OverPassRequest(bBoxGrenoble, "node", "amenity", "pharmacy");
//
//        OverPassClient client = new OverPassClient();
//
//        OverPassResponse resp = client.send(req);
//
//        OverPass2OF4OSMFolksoParser folksoParser = new OverPass2OF4OSMFolksoParser();
//
//        OF4OSMFolkso folkso = folksoParser.parse(resp);
//
//        System.out.println(folkso);
//        
//        Folkso2CSVParser csv = new Folkso2CSVParser();
//                
//        FileUtils.writeStringToFile(
//    			new File("C:\\Users\\amehiris\\Documents\\overPassFolkso.csv"), 
//    			csv.parse(folkso));
//        
        // Grenoble centre 
        OSMAPIRequest req = new OSMAPIRequest("5.7180328", "45.1873363", "5.724524", "45.188529");
        // Grrenoble 
        //   OSMAPIRequest req = new OSMAPIRequest("5.712204", "45.178649", "5.727654", "45.189538");
        OSMAPIClient client = new OSMAPIClient();

        OSMAPIResponse resp = client.send(req);

        IOF4OSMFolkso folkso = OSMAPI2FolksoParser.parse(resp);

        FileUtils.writeStringToFile(
                new File("C:\\Users\\amehiris\\Documents\\osmapiFolksoG.csv"),
                Folkso2CSVParser.parse(folkso));

        onto = Folkso2OntoParser.addConceptsFromFolkso(onto, folkso);
        onto.afficher();

    }

}
