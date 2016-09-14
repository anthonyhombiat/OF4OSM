/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overPass;

import java.io.IOException;
import java.net.MalformedURLException;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.util.OF4OSMFolkso2CSV;

/**
 *
 * @author amehiris
 */
public class OverPassClientTest {

    public static void main(String[] args) throws MalformedURLException, IOException, Exception {

        String bBoxGrenobleCentre = "(45.1873363,5.7180328,45.188529,5.724524)";
        String bBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
        
        OverPassRequest req = new OverPassRequest(bBoxGrenoble, "node", "amenity", "pharmacy");

        OverPassClient client = new OverPassClient();

        OverPassResponse resp = client.send(req);

        OverPass2OF4OSMFolksoParser parser = new OverPass2OF4OSMFolksoParser();

        OF4OSMFolkso folkso = parser.parse(resp);

        System.out.println(folkso);
        
        OF4OSMFolkso2CSV csv = new OF4OSMFolkso2CSV();
        
        csv.write(csv.parse(folkso),"C:\\Users\\amehiris\\Documents\\test1.csv");
        
        
    }

}
