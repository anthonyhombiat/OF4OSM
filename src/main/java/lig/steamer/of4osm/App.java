package lig.steamer.of4osm;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.util.OF4OSMFolkso2CSV;
import lig.steamer.of4osm.util.OF4OSMFolkso2OntoParser;
import lig.steamer.of4osm.ws.osmapi.OSMAPI2OF4OSMFolksoParser;
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
//        OF4OSMFolkso2CSV csv = new OF4OSMFolkso2CSV();
//                
//        FileUtils.writeStringToFile(new File("C:\\Users\\amehiris\\Documents\\overPassFolkso.csv"), csv.parse(folkso));
//        
        OSMAPIRequest req = new OSMAPIRequest("5.712204", "45.178649", "5.727654", "45.189538");

        OSMAPIClient client = new OSMAPIClient();

        OSMAPIResponse resp = client.send(req);

        OF4OSMFolkso folkso = OSMAPI2OF4OSMFolksoParser.parse(resp);

        System.out.println(folkso);

        FileUtils.writeStringToFile(new File("C:\\Users\\amehiris\\Documents\\osmapiFolkso.csv"), OF4OSMFolkso2CSV.parse(folkso));

        OF4OSMFolkso2OntoParser ontoParser = new OF4OSMFolkso2OntoParser();

        OF4OSMOntology onto = ontoParser.parse(folkso);

        onto.afficher();

    }

}
