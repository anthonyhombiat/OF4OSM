/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.net.MalformedURLException;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.util.OF4OSMFolkso2CSV;

/**
 *
 * @author amehiris
 */
public class OSMAPIClientTest {

    public static void main(String[] args) throws MalformedURLException, Exception {

        OSMAPIRequest req = new OSMAPIRequest("5.712204", "45.178649", "5.727654", "45.189538");
        
        OSMAPIClient client = new OSMAPIClient();
        
        OSMAPIResponse resp = client.send(req);
        
        OSMAPI2OF4OSMFolksoParser parser = new OSMAPI2OF4OSMFolksoParser();
        
        OF4OSMFolkso folkso = parser.parse(resp);
        
        System.out.println(folkso);
        
        OF4OSMFolkso2CSV csv = new OF4OSMFolkso2CSV();       
        csv.write(csv.parse(folkso),"C:\\Users\\amehiris\\Documents\\test1.csv");

    }
}
