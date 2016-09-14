/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.Map;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTag;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParser.stringToKey;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParser.stringToValue;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParser.typeTags;

/**
 *
 * @author amehiris
 */
public class OSMAPI2OF4OSMFolksoParser {

    public OSMAPI2OF4OSMFolksoParser() {
    }
    
    public OF4OSMFolkso parse(OSMAPIResponse resp) throws Exception{
        
        OF4OSMFolkso typologyTags = new OF4OSMFolkso();
         Map<OSMAPITag, Integer> tags = resp.getTags();           
            for (Map.Entry<OSMAPITag, Integer> entry : tags.entrySet()) {
                OSMTagKey key = stringToKey(entry.getKey().getK(),"");
                OSMTagValue value = stringToValue(entry.getKey().getV());
                OSMTag type = typeTags(key, value);
                typologyTags.addTag(type, entry.getValue());
            }
            return typologyTags;
    }
    
}
