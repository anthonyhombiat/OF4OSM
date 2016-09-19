/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.Map;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
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
    
    public static OF4OSMFolkso parse(OSMAPIResponse resp) throws Exception{
        
        OF4OSMFolkso osmapiFolkso = new OF4OSMFolkso();
         Map<OSMAPITag, Integer> tags = resp.getTags();           
            for (Map.Entry<OSMAPITag, Integer> entry : tags.entrySet()) {
                IOSMTagKey key = stringToKey(entry.getKey().getK(),"");
                IOSMTagValue value = stringToValue(entry.getKey().getV());
                IOSMTag type = typeTags(key, value);
                osmapiFolkso.addTag(type, entry.getValue());
            }
            return osmapiFolkso;
    }
    
}
