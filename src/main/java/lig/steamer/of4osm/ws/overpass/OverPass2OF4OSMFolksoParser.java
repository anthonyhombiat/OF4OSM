/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overpass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
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
public final class OverPass2OF4OSMFolksoParser {

    public static OF4OSMFolkso parse(OverPassResponse resp) throws Exception {
        OF4OSMFolkso overPassFolkso = new OF4OSMFolkso();

        Map<OverPassTag, Integer> tags = extractOverPassTags(resp);
        for (Map.Entry<OverPassTag, Integer> entry : tags.entrySet()) {
            IOSMTagKey key = stringToKey(entry.getKey().getK(), "");
            IOSMTagValue value = stringToValue(entry.getKey().getV());
            IOSMTag type = typeTags(key, value);
            overPassFolkso.addTag(type, entry.getValue());
        }
        return overPassFolkso;
    }
    
    private static Map<OverPassTag, Integer> extractOverPassTags(OverPassResponse resp) {

        Map<OverPassTag, Integer> tags = new HashMap<>();

        List<OverPassElement> elements = resp.getElements();
        for (OverPassElement element : elements) {

            Map<String, String> mapTags = element.getTags();

            for (Map.Entry<String, String> entry : mapTags.entrySet()) {
                OverPassTag overPassTag = new OverPassTag(entry.getKey(), entry.getValue());

                if (tags.get(overPassTag) == null) {
                    tags.put(overPassTag, 1);
                } else {
                    int nbOccur = tags.get(overPassTag);
                    tags.put(overPassTag, 1 + nbOccur);
                }
            }
        }

        return tags;
    }
}
