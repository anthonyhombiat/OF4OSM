package lig.steamer.of4osm;

import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolkso;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMTag;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParser.stringToKey;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParser.stringToValue;
import static lig.steamer.of4osm.util.String2OF4OSMFolksoParser.typeTags;
import lig.steamer.of4osm.ws.overPass.OverPassResponse;
import lig.steamer.of4osm.ws.overPass.OverPassTag;
import lig.steamer.of4osm.ws.tagInfo.TagsPopularWsClient;
import lig.steamer.of4osm.ws.tagInfo.TagsPopularData;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws MalformedURLException, IOException, Exception {

        OF4OSMFolkso statTypeTags = new OF4OSMFolkso();

        String bBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
        String bBoxGrenobleCentre = "(45.1873363,5.7180328,45.188529,5.724524)";
        String bBoxParis = "(48.658291,2.08679,49.04694,2.63791)";
//
//        TagsPopularWsClient tagsPopular = new TagsPopularWsClient();
//        List<TagsPopularData> dataPopularTags = tagsPopular.getTagsPopularHead().getData();
//        for (TagsPopularData popularTags : dataPopularTags) {
//
//            OSMTagKey key = stringToKey(popularTags.getKey(), "");
//            OSMTagValue value = stringToValue(popularTags.getValue());
//            OSMTag type = typeTags(key, value);
//            statTypeTags.addTag(type,popularTags.getCount_all());
//        }
//
//        OverPass overPasse = new OverPass (bBoxGrenoble, "node", "amenity", "pharmacy");
//        Map<OverPassTag, Integer> tags = overPasse.getTags();
//        for (Map.Entry<OverPassTag, Integer> entry : tags.entrySet()) {
//            OSMTagKey key = stringToKey(entry.getKey().getK(), "");
//            OSMTagValue value = stringToValue(entry.getKey().getV());
//            OSMTag type = typeTags(key, value);
//            statTypeTags.addTag(type,entry.getValue());
//        }

        statTypeTags.afficher();
        statTypeTags.writeToFile();

    }

}
