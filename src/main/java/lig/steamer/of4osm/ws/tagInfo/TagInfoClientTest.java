package lig.steamer.of4osm.ws.tagInfo;

import java.io.IOException;
import java.net.MalformedURLException;

public class TagInfoClientTest {

	public static void main(String[] args) {

		TagInfoClient client = new TagInfoClient();
		try {
			System.out.println(client.tagsPopular());
		} catch (MalformedURLException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
		}
		
	}

}
