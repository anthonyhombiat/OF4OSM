package lig.steamer.of4osm;

import java.io.IOException;
import java.net.MalformedURLException;
import lig.steamer.of4osm.ws.tagInfo.TagInfo;
import lig.steamer.of4osm.ws.tagInfo.TagsPopularHead;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws MalformedURLException, IOException {
        
        TagInfo tagInfo = new TagInfo();
        TagsPopularHead tagsPopularHead = tagInfo.tagsPopular();
        System.out.println(tagsPopularHead.toString());
        
    }
}
