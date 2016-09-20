package lig.steamer.of4osm.ws.tagInfo;


public class TagInfoClientTest {

	public static void main(String[] args) {

		TagsPopularClient client = new TagsPopularClient();
		System.out.println(client.send());
		
	}

}
