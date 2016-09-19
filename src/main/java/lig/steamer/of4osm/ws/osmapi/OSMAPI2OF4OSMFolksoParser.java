/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.osmapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso2;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParsingTool.stringToKey;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParsingTool.stringToValue;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParsingTool.typeTags;

/**
 *
 * @author amehiris
 */
public final class OSMAPI2OF4OSMFolksoParser {

    public static OF4OSMFolkso parse(OSMAPIResponse resp) throws Exception{
        
        OF4OSMFolkso osmapiFolkso = new OF4OSMFolkso();
         Map<OSMAPITag, Integer> tags = getTags(resp);           
            for (Map.Entry<OSMAPITag, Integer> entry : tags.entrySet()) {
                IOSMTagKey key = stringToKey(entry.getKey().getK(),"");
                IOSMTagValue value = stringToValue(entry.getKey().getV());
                IOSMTag type = typeTags(key, value);
                osmapiFolkso.addTag(type, entry.getValue());
            }
            return osmapiFolkso;
    }
    
    public static OF4OSMFolkso2 parse2(OSMAPIResponse resp) throws Exception{
        
        OF4OSMFolkso2 folkso = new OF4OSMFolkso2();
        
        
        
        return folkso;
    }
    
    private static Map<OSMAPITag, Integer> getTags(OSMAPIResponse resp) {

        Map<OSMAPITag, Integer> tags = new HashMap();

        for (OSMAPINode node1 : resp.getNode()) {
            if (node1.getTag() != null) {
                if (tags.get(node1.getTag()) == null) {
                    tags.put(node1.getTag(), 1);
                } else {
                    int nbOccur = tags.get(node1.getTag());
                    tags.put(node1.getTag(), 1 + nbOccur);
                }
            }
        }

        for (OSMAPIRelation relation1 : resp.getRelation()) {
            if (relation1.getTag() != null) {
                List<OSMAPITag> tag = relation1.getTag();
                for (OSMAPITag tag1 : tag) {
                    if (tags.get(tag1) == null) {
                        tags.put(tag1, 1);
                    } else {
                        int nbOccur = tags.get(tag1);
                        tags.put(tag1, 1 + nbOccur);
                    }
                }
            }
        }

        for (OSMAPIWay way1 : resp.getWay()) {
            if (way1.getTag() != null) {
                List<OSMAPITag> tag = way1.getTag();
                for (OSMAPITag tag1 : tag) {
                    if (tags.get(tag1) == null) {
                        tags.put(tag1, 1);
                    } else {
                        int nbOccur = tags.get(tag1);
                        tags.put(tag1, 1 + nbOccur);
                    }
                }
            }
        }

        return tags;
    }
    
}
