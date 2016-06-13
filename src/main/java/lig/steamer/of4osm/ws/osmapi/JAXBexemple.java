/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.io.File;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import static lig.steamer.of4osm.App.stringToKey;
import static lig.steamer.of4osm.App.stringToValue;
import static lig.steamer.of4osm.App.typeTags;
import lig.steamer.of4osm.StatTypeTags;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMTag;

/**
 *
 * @author amehiris
 */
public class JAXBexemple {

    public static void main(String[] args) {

        StatTypeTags statTypeTags = new StatTypeTags();
        try {

            File file = new File("C:\\Users\\amehiris\\Downloads\\xapi.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Osm.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Osm osm = (Osm) jaxbUnmarshaller.unmarshal(file);
            Map<Tag,Integer> tags = osm.getTags();
                    for (Map.Entry<Tag, Integer> entry : tags.entrySet()) {
                        OSMTagKey key = stringToKey(entry.getKey().getK(), "");
                        OSMTagValue value = stringToValue(entry.getKey().getV());
                        OSMTag type = typeTags(key, value);
                        statTypeTags.addType(type,entry.getValue());
                    }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        statTypeTags.afficher();
        statTypeTags.writeToFile();
    }

}
