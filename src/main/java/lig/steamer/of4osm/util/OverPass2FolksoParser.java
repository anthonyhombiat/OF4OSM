/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lig.steamer.of4osm.IOF4OSMFolkso;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;

import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;
import static lig.steamer.of4osm.util.FolksoParsingTool.stringToKey;
import static lig.steamer.of4osm.util.FolksoParsingTool.stringToValue;
import static lig.steamer.of4osm.util.FolksoParsingTool.typeTags;
import lig.steamer.of4osm.ws.overpass.OverPassElement;
import lig.steamer.of4osm.ws.overpass.OverPassResponse;
import lig.steamer.of4osm.ws.overpass.OverPassTag;

/**
 *
 * @author amehiris
 */
public final class OverPass2FolksoParser {

    public static IOF4OSMFolkso parse(OverPassResponse resp) throws Exception {

        OF4OSMFolkso overPassFolkso = new OF4OSMFolkso();

        Map<String, Set<OverPassTag>> tags = extractOverPassTags(resp);
        for (Map.Entry<String, Set<OverPassTag>> entry : tags.entrySet()) {
            Set<IOSMTag> osmTags = new HashSet<>();
            for (OverPassTag tag : entry.getValue()) {
                IOSMTagKey key = stringToKey(tag.getK(), "");
                IOSMTagValue value = stringToValue(tag.getV());
                IOSMTag osmTag = typeTags(key, value);

                osmTags.add(osmTag);
            }

            overPassFolkso.addTags(entry.getKey(), osmTags);

        }
        return overPassFolkso;
    }

    private static Map<String, Set<OverPassTag>> extractOverPassTags(OverPassResponse resp) {

        Map<String, Set<OverPassTag>> tags = new HashMap<>();

        List<OverPassElement> elements = resp.getElements();

        for (OverPassElement element : elements) {

            Map<String, String> mapTags = element.getTags();
            Set<OverPassTag> setOverPass = new HashSet<>();
            for (Map.Entry<String, String> entry : mapTags.entrySet()) {
                OverPassTag overPassTag = new OverPassTag(entry.getKey(), entry.getValue());
                setOverPass.add(overPassTag);
            }
            tags.put(element.getId(), setOverPass);
        }
        return tags;
    }
}
