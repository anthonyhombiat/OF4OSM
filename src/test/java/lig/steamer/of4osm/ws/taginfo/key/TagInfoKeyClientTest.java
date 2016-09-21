package lig.steamer.of4osm.ws.taginfo.key;

import junit.framework.TestCase;
import lig.steamer.of4osm.ws.taginfo.key.TagInfoKeyAction;
import lig.steamer.of4osm.ws.taginfo.key.TagInfoKeyClient;
import lig.steamer.of4osm.ws.taginfo.key.similar.TagInfoKeySimilarResponse;
import lig.steamer.of4osm.ws.taginfo.key.stats.TagInfoKeyStatsResponse;
import lig.steamer.of4osm.ws.taginfo.key.values.TagInfoKeyValuesResponse;
import lig.steamer.of4osm.ws.taginfo.key.combinations.TagInfoKeyCombinationsResponse;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class TagInfoKeyClientTest extends TestCase {

	public TagInfoKeyClientTest(String name) {
		super(name);
	}

	public void testSend() {
		
		final String key = "amenity";
		
		TagInfoKeyClient keyClient = new TagInfoKeyClient();
		
		TagInfoKeyValuesResponse keyValuesResponse = 
				(TagInfoKeyValuesResponse) keyClient.send(TagInfoKeyAction.VALUES, key);
		
		assertNotNull(keyValuesResponse);
		
		TagInfoKeySimilarResponse keySimilarResponse = 
				(TagInfoKeySimilarResponse) keyClient.send(TagInfoKeyAction.SIMILAR, key);
		
		assertNotNull(keySimilarResponse);

		TagInfoKeyStatsResponse keyStatsResponse = 
				(TagInfoKeyStatsResponse) keyClient.send(TagInfoKeyAction.STATS, key);
		
		assertNotNull(keyStatsResponse);
		
		TagInfoKeyCombinationsResponse keyCombinationsResponse = 
				(TagInfoKeyCombinationsResponse) keyClient.send(TagInfoKeyAction.COMBINATIONS, key);
		
		assertNotNull(keyCombinationsResponse);
	}

}
