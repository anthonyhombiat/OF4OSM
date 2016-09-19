/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.io.File;
import java.net.MalformedURLException;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.core.onto.impl.OF4OSMOntology;
import lig.steamer.of4osm.util.OF4OSMFolkso2CSV;
import lig.steamer.of4osm.util.OF4OSMFolkso2OntoParser;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author amehiris
 */
public class OSMAPIClientTest {

    public static void main(String[] args) throws MalformedURLException, Exception {
        
        OSMAPIRequest req = new OSMAPIRequest("5.712204", "45.178649", "5.727654", "45.189538");

        OSMAPIClient client = new OSMAPIClient();

        OSMAPIResponse resp = client.send(req);

        OF4OSMFolkso folkso = OSMAPI2OF4OSMFolksoParser.parse(resp);

        System.out.println(folkso);

        FileUtils.writeStringToFile(new File("C:\\Users\\amehiris\\Documents\\test1.csv"), OF4OSMFolkso2CSV.parse(folkso));

        OF4OSMFolkso2OntoParser ontoParser = new OF4OSMFolkso2OntoParser();

        OF4OSMOntology onto = ontoParser.parse(folkso);

        onto.afficher();

    }
}
