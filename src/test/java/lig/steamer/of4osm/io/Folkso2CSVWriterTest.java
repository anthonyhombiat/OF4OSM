package lig.steamer.of4osm.io;

import java.io.File;
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

public class Folkso2CSVWriterTest extends TestCase {

	private OF4OSMFolksonomy folkso;
	
	public Folkso2CSVWriterTest(String name) {
		
		super(name);
		
		folkso = new OF4OSMFolksonomy();
		
		IOSMTagSimpleKey key1 = new OSMTagSimpleKey("historic", "");
        IOSMTagStringValue value1 = new OSMTagStringValue("castle");
        IOSMCategoryTag tag1 = new OSMSimpleCategoryTag(key1, value1);

        IOSMTagSimpleKey key2 = new OSMTagSimpleKey("amenity", "");
        IOSMTagStringValue value2 = new OSMTagStringValue("restaurant");
        IOSMCategoryTag tag2 = new OSMSimpleCategoryTag(key2, value2);

        IOSMTagSimpleKey key3 = new OSMTagSimpleKey("tourism", "");
        IOSMTagStringValue value3 = new OSMTagStringValue("hotel");
        IOSMCategoryTag tag3 = new OSMSimpleCategoryTag(key3, value3);

        Set<IOSMTag> tags = new HashSet<>();
        tags.add(tag1);
        tags.add(tag2);
        tags.add(tag3);
        
        folkso.addTags("test", tags);
        
	}

	public void testParse(){
        assertNotNull(Folkso2CSVWriter.parse(folkso));
	}
	
	public void testWrite(){
		Folkso2CSVWriter.write(folkso);
	}
	
}
