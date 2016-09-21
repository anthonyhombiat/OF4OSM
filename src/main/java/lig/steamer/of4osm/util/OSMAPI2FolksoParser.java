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
import lig.steamer.of4osm.ws.osmapi.OSMAPINode;
import lig.steamer.of4osm.ws.osmapi.OSMAPIRelation;
import lig.steamer.of4osm.ws.osmapi.OSMAPIResponse;
import lig.steamer.of4osm.ws.osmapi.OSMAPITag;
import lig.steamer.of4osm.ws.osmapi.OSMAPIWay;
import static lig.steamer.of4osm.util.FolksoParsingTool.stringToKey;
import static lig.steamer.of4osm.util.FolksoParsingTool.stringToValue;
import static lig.steamer.of4osm.util.FolksoParsingTool.typeTags;

/**
 *
 * @author amehiris
 */
public final class OSMAPI2FolksoParser {

    public static IOF4OSMFolkso parse(OSMAPIResponse resp) throws Exception {

        OF4OSMFolkso folkso = new OF4OSMFolkso();

        Map<String, Set<OSMAPITag>> tags = getTags(resp);
        for (Map.Entry<String, Set<OSMAPITag>> entry : tags.entrySet()) {
            Set<IOSMTag> osmTags = new HashSet<>();
            for (OSMAPITag tag : entry.getValue()) {
                IOSMTagKey key = stringToKey(tag.getK(), "");
                IOSMTagValue value = stringToValue(tag.getV());
                IOSMTag osmTag = typeTags(key, value);

                osmTags.add(osmTag);
            }

            folkso.addTags(entry.getKey(), osmTags);

        }
        return folkso;
    }

    private static Map<String, Set<OSMAPITag>> getTags(OSMAPIResponse resp) {

        Map<String, Set<OSMAPITag>> tags = new HashMap<>();

        for (OSMAPINode node1 : resp.getNode()) {
            if (node1.getTag() != null) {
                List<OSMAPITag> listTag = node1.getTag();
                Set setTag = new HashSet(listTag);
                tags.put(node1.getId(), setTag);
            }
        }

        for (OSMAPIRelation relation1 : resp.getRelation()) {
            if (relation1.getTag() != null) {
                List<OSMAPITag> listTag = relation1.getTag();
                Set setTag = new HashSet(listTag);
                tags.put(relation1.getId(), setTag);
            }
        }

        for (OSMAPIWay way1 : resp.getWay()) {
            if (way1.getTag() != null) {
                List<OSMAPITag> listTag = way1.getTag();
                Set setTag = new HashSet(listTag);
                tags.put(way1.getId(), setTag);
            }
        }
        return tags;
    }

}
