package lig.steamer.of4osm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.component.impl.OSMTagValue;
import lig.steamer.of4osm.core.folkso.tag.typology.impl.OSMTag;
import static lig.steamer.of4osm.util.ParserOF4OSM.stringToKey;
import static lig.steamer.of4osm.util.ParserOF4OSM.stringToValue;
import static lig.steamer.of4osm.util.ParserOF4OSM.typeTags;
import lig.steamer.of4osm.ws.tagInfo.TagsPopularWsClient;
import lig.steamer.of4osm.ws.tagInfo.TagsPopularData;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws MalformedURLException, IOException {

        StatTypeTags statTypeTags = new StatTypeTags();

        String bBoxGrenoble = "(45.154005,5.678004,45.214326,5.753081)";
        String bBoxGrenobleCentre = "(45.1873363,5.7180328,45.188529,5.724524)";
        String bBoxParis = "(48.658291,2.08679,49.04694,2.63791)";

        TagsPopularWsClient tagsPopular = new TagsPopularWsClient();
        List<TagsPopularData> dataPopularTags = tagsPopular.getTagsPopularHead().getData();
        for (TagsPopularData popularTags : dataPopularTags) {

            OSMTagKey key = stringToKey(popularTags.getKey(), "");
            OSMTagValue value = stringToValue(popularTags.getValue());
            OSMTag type = typeTags(key, value);
            statTypeTags.addType(type,popularTags.getCount_all());
        }

//        OverPass overPasse = new OverPass(bBoxGrenoble, "node", "amenity", "pharmacy");
//        Map<Tag, Integer> tags = overPasse.getTags();
//        for (Map.Entry<Tag, Integer> entry : tags.entrySet()) {
//            OSMTagKey key = stringToKey(entry.getKey().getK(), "");
//            OSMTagValue value = stringToValue(entry.getKey().getV());
//            OSMTag type = typeTags(key, value);
//            statTypeTags.addType(type,entry.getValue());
//        }

        statTypeTags.afficher();
        statTypeTags.writeToFile();

    }

}
