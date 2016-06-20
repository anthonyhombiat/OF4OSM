/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import lig.steamer.of4osm.StatTypeTags;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMTag;
import static lig.steamer.of4osm.util.ParserOF4OSM.stringToKey;
import static lig.steamer.of4osm.util.ParserOF4OSM.stringToValue;
import static lig.steamer.of4osm.util.ParserOF4OSM.typeTags;

/**
 *
 * @author amehiris
 */
public class JAXBexemple {

    public static void main(String[] args) throws MalformedURLException {

        StatTypeTags statTypeTags = new StatTypeTags();
        try {
 
            JAXBContext jaxbContext = JAXBContext.newInstance(Osm.class);
                                                                            
            URL url = new URL("http://api.openstreetmap.org/api/0.6/map?bbox=5.712204,45.178649,5.727654,45.189538");
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Osm osm = (Osm) jaxbUnmarshaller.unmarshal(url);
            
            Map<Tag, Integer> tags = osm.getTags();
            for (Map.Entry<Tag, Integer> entry : tags.entrySet()) {
                OSMTagKey key = stringToKey(entry.getKey().getK(), "");
                OSMTagValue value = stringToValue(entry.getKey().getV());
                OSMTag type = typeTags(key, value);
                statTypeTags.addType(type, entry.getValue());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        statTypeTags.afficher();
        statTypeTags.writeToFile();
    }

}
