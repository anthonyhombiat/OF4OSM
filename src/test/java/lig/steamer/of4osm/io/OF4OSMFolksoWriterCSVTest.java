package lig.steamer.of4osm.io;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import lig.steamer.of4osm.core.folkso.impl.OF4OSMFolksonomy;
import lig.steamer.of4osm.core.folkso.tag.IOSMCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTag;
import lig.steamer.of4osm.core.folkso.tag.impl.OSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;

public class OF4OSMFolksoWriterCSVTest extends TestCase {

	private OF4OSMFolksonomy folkso;
	
	public OF4OSMFolksoWriterCSVTest(String name) {
		
		super(name);
		
		folkso = new OF4OSMFolksonomy();
		
		final IOSMTagSimpleKey key1 = new OSMTagSimpleKey("historic", "");
		final IOSMTagStringValue value1 = new OSMTagStringValue("castle");
        final IOSMCategoryTag tag1 = new OSMSimpleCategoryTag(key1, value1);

        final IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
        final IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
        final IOSMCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);

        final IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
        final IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
        final IOSMCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);

        Set<IOSMTag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag2);
        tags.add(tag3);
        
        folkso.addTagsByElement("test", tags);
        
	}

	public void testParse(){
        assertNotNull(OF4OSMFolksoWriterCSV.parse(folkso));
	}
	
	public void testWrite(){
		String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		OF4OSMFolksoWriterCSV.write(folkso, "osmtags-test" + now);
	}
	
}
