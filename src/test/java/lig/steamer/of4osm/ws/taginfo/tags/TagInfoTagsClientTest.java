package lig.steamer.of4osm.ws.taginfo.tags;

import junit.framework.TestCase;
import lig.steamer.of4osm.ws.taginfo.tags.TagInfoTagsAction;
import lig.steamer.of4osm.ws.taginfo.tags.TagInfoTagsClient;
import lig.steamer.of4osm.ws.taginfo.tags.popular.TagInfoTagsPopularResponse;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public class TagInfoTagsClientTest extends TestCase {

	public TagInfoTagsClientTest(String name) {
		super(name);
	}

	public void testSend() {

		TagInfoTagsClient tagsClient = new TagInfoTagsClient();
		
		TagInfoTagsPopularResponse tagsPopularResponse = 
				(TagInfoTagsPopularResponse) tagsClient.send(TagInfoTagsAction.POPULAR);
		
		assertNotNull(tagsPopularResponse);
		
	}

}
