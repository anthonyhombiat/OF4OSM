package lig.steamer.of4osm.ws.taginfo.tag;

import junit.framework.TestCase;
import lig.steamer.of4osm.ws.taginfo.tag.TagInfoTagAction;
import lig.steamer.of4osm.ws.taginfo.tag.TagInfoTagClient;
import lig.steamer.of4osm.ws.taginfo.tag.stats.TagInfoTagStatsResponse;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class TagInfoTagClientTest extends TestCase {

	public TagInfoTagClientTest(String name) {
		super(name);
	}

	public void testSend() {
		
		final String key = "amenity";
		final String value = "school";
		
		final TagInfoTagClient tagClient = new TagInfoTagClient();
		
		final TagInfoTagStatsResponse tagStatsResponse = 
				(TagInfoTagStatsResponse) tagClient.send(TagInfoTagAction.STATS, key, value);
		
		assertNotNull(tagStatsResponse);
	}

}
