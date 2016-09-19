/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.ws.overPass;

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
public class OverPass2OF4OSMFolksoParser {

    public OverPass2OF4OSMFolksoParser() {
    }

    public OF4OSMFolkso parse(OverPassResponse resp) throws Exception {
        OF4OSMFolkso overPassFolkso = new OF4OSMFolkso();

        Map<OverPassTag, Integer> tags = resp.extractOverPassTags();
        for (Map.Entry<OverPassTag, Integer> entry : tags.entrySet()) {
            IOSMTagKey key = stringToKey(entry.getKey().getK(), "");
            IOSMTagValue value = stringToValue(entry.getKey().getV());
            IOSMTag type = typeTags(key, value);
            overPassFolkso.addTag(type, entry.getValue());
        }
        return overPassFolkso;
    }
}
