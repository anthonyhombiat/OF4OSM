package lig.steamer.of4osm.tools.utils;

import java.util.Date;

import junit.framework.TestCase;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMComplexKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMLocalizedKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMMultipleValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyBooleanValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyDateValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyNumericValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMSimpleKeyStringValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMStatefulCategoryTag;
import lig.steamer.of4osm.core.folkso.tag.IOSMTimeDomainsValuePropertyTag;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagComplexKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagLocalizedKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagSimpleKey;
import lig.steamer.of4osm.core.folkso.tag.key.impl.OSMTagStatefulKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagDateValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagNumericValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagTimeDomainsValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagBooleanValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagDateValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagMultipleValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagNumericValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagStringValue;
import lig.steamer.of4osm.core.folkso.tag.value.impl.OSMTagTimeDomainsValue;
import lig.steamer.of4osm.tools.utils.OF4OSMTagIdentifier;

public class OF4OSMTagIdentifierTest extends TestCase {

	public OF4OSMTagIdentifierTest(String name) {
		super(name);
	}
	
	public void testIdentifyKey(){
		final String simpleKeyString = "amenity";
		final String localizedKeyString = "name:fr";
		final String statefulKeyString = "abandoned:shop";
		final String complexKeyString1 = "climbing:grade";
		final String complexKeyString2 = "climbing:grade:french";
		
		final IOSMTagSimpleKey simpleKey = (IOSMTagSimpleKey) OF4OSMTagIdentifier.identifyKey(simpleKeyString, "");
		final IOSMTagLocalizedKey localizedKey = (IOSMTagLocalizedKey) OF4OSMTagIdentifier.identifyKey(localizedKeyString, "");
		final IOSMTagStatefulKey statefulKey = (IOSMTagStatefulKey) OF4OSMTagIdentifier.identifyKey(statefulKeyString, "");
		final IOSMTagComplexKey complexKey1 = (IOSMTagComplexKey) OF4OSMTagIdentifier.identifyKey(complexKeyString1, "");
		final IOSMTagComplexKey complexKey2 = (IOSMTagComplexKey) OF4OSMTagIdentifier.identifyKey(complexKeyString2, "");
		
		assertEquals("amenity", simpleKey.getValue());
		assertEquals("name", localizedKey.getValue());
		assertEquals("fr", localizedKey.getLocale());
		assertEquals("shop", statefulKey.getValue());
		assertEquals("abandoned", statefulKey.getState());
		assertEquals("climbing", complexKey1.getValue());
		assertEquals("grade", complexKey1.getPrefixes().get(0));
		assertEquals("french", complexKey2.getPrefixes().get(1));
	}
	
	public void testIdentifyValue(){
		final String booleanValueString1 = "yes";
		final String booleanValueString2 = "no";
		final String booleanValueString3 = "oui";
		final String booleanValueString4 = "non";
		final String booleanValueString5 = "true";
		final String booleanValueString6 = "false";
		final String dateValueString1 = "2000/01/01";
		final String dateValueString2 = "2000-01-01";
		final String dateValueString3 = "10 Jan 2000";
		final String dateValueString4 = "2000-01-01T01:01:01";
		final String numericValueString1 = "1,234";
		final String numericValueString2 = "1.234";
		final String stringValueString = "school";
		final String timeDomainsValueString = "Sa-Su 00:00-24:00";
		final String multipleValueString = "bar;restaurant;pizzeria";
		
		final IOSMTagBooleanValue booleanValue1 = (IOSMTagBooleanValue) OF4OSMTagIdentifier.identifyValue(booleanValueString1);
		final IOSMTagBooleanValue booleanValue2 = (IOSMTagBooleanValue) OF4OSMTagIdentifier.identifyValue(booleanValueString2);
		final IOSMTagBooleanValue booleanValue3 = (IOSMTagBooleanValue) OF4OSMTagIdentifier.identifyValue(booleanValueString3);
		final IOSMTagBooleanValue booleanValue4 = (IOSMTagBooleanValue) OF4OSMTagIdentifier.identifyValue(booleanValueString4);
		final IOSMTagBooleanValue booleanValue5 = (IOSMTagBooleanValue) OF4OSMTagIdentifier.identifyValue(booleanValueString5);
		final IOSMTagBooleanValue booleanValue6 = (IOSMTagBooleanValue) OF4OSMTagIdentifier.identifyValue(booleanValueString6);
		final IOSMTagDateValue dateValue1 = (IOSMTagDateValue) OF4OSMTagIdentifier.identifyValue(dateValueString1);
		final IOSMTagDateValue dateValue2 = (IOSMTagDateValue) OF4OSMTagIdentifier.identifyValue(dateValueString2);
		final IOSMTagDateValue dateValue3 = (IOSMTagDateValue) OF4OSMTagIdentifier.identifyValue(dateValueString3);
		final IOSMTagDateValue dateValue4 = (IOSMTagDateValue) OF4OSMTagIdentifier.identifyValue(dateValueString4);
		final IOSMTagNumericValue numericValue1 = (IOSMTagNumericValue) OF4OSMTagIdentifier.identifyValue(numericValueString1);
		final IOSMTagNumericValue numericValue2 = (IOSMTagNumericValue) OF4OSMTagIdentifier.identifyValue(numericValueString2);
		final IOSMTagStringValue stringValue = (IOSMTagStringValue) OF4OSMTagIdentifier.identifyValue(stringValueString);
		final IOSMTagTimeDomainsValue timeDomainsValue = (IOSMTagTimeDomainsValue) OF4OSMTagIdentifier.identifyValue(timeDomainsValueString);
		final IOSMTagMultipleValue multipleValue = (IOSMTagMultipleValue) OF4OSMTagIdentifier.identifyValue(multipleValueString);
		
		assertTrue(booleanValue1.getValue());
		assertFalse(booleanValue2.getValue());
		assertTrue(booleanValue3.getValue());
		assertFalse(booleanValue4.getValue());
		assertTrue(booleanValue5.getValue());
		assertFalse(booleanValue6.getValue());
		assertNotNull(dateValue1);
		assertNotNull(dateValue2);
		assertNotNull(dateValue3);
		assertNotNull(dateValue4);
		assertNotNull(numericValue1);
		assertNotNull(numericValue2);
		assertNotNull(stringValue);
		assertNotNull(timeDomainsValue);
		assertEquals("bar", multipleValue.getValues()[0]);
		assertEquals("restaurant", multipleValue.getValues()[1]);
		assertEquals("pizzeria", multipleValue.getValues()[2]);
	}
	
	public void testIdentifyTag(){
		final IOSMTagSimpleKey simplePropertyKey = new OSMTagSimpleKey("name", "");
		final IOSMTagSimpleKey simpleCategoryKey = new OSMTagSimpleKey("amenity", "");
		final IOSMTagComplexKey complexKey = new OSMTagComplexKey("climbing:grade:french", "");
		final IOSMTagLocalizedKey localizedKey = new OSMTagLocalizedKey("name:fr", "");
		final IOSMTagStatefulKey statefulKey = new OSMTagStatefulKey("abandoned:shop", "");
		
		final IOSMTagBooleanValue booleanValue = new OSMTagBooleanValue(true);
		final IOSMTagNumericValue numericValue = new OSMTagNumericValue(1.0);
		final IOSMTagTimeDomainsValue timeDomains = new OSMTagTimeDomainsValue("Sa-Su 00:00-24:00");
		final IOSMTagDateValue dateValue = new OSMTagDateValue(new Date());
		final IOSMTagStringValue stringValue = new OSMTagStringValue("school");
		final IOSMTagMultipleValue multipleValue = new OSMTagMultipleValue(new String[]{"bar","restaurant","pizzeria"});
		
		final IOSMSimpleCategoryTag simpleCategoryTag = (IOSMSimpleCategoryTag) OF4OSMTagIdentifier.identifyTag(simpleCategoryKey, stringValue);
		final IOSMStatefulCategoryTag statefulCategoryTag = (IOSMStatefulCategoryTag) OF4OSMTagIdentifier.identifyTag(statefulKey, stringValue);
		final IOSMMultipleCategoryTag multipleCategoryTag = (IOSMMultipleCategoryTag) OF4OSMTagIdentifier.identifyTag(simpleCategoryKey, multipleValue);
		
		final IOSMSimpleKeyStringValuePropertyTag simpleKeyStringValuePropertyTag = (IOSMSimpleKeyStringValuePropertyTag) OF4OSMTagIdentifier.identifyTag(simplePropertyKey, stringValue);
		final IOSMComplexKeyStringValuePropertyTag complexKeyStringValuePropertyTag = (IOSMComplexKeyStringValuePropertyTag) OF4OSMTagIdentifier.identifyTag(complexKey, stringValue);
		final IOSMLocalizedKeyStringValuePropertyTag localizedKeyStringValuePropertyTag = (IOSMLocalizedKeyStringValuePropertyTag) OF4OSMTagIdentifier.identifyTag(localizedKey, stringValue);
		final IOSMSimpleKeyNumericValuePropertyTag simpleKeyNumericValuePropertyTag = (IOSMSimpleKeyNumericValuePropertyTag) OF4OSMTagIdentifier.identifyTag(simplePropertyKey, numericValue);
		final IOSMComplexKeyNumericValuePropertyTag complexKeyNumericValuePropertyTag = (IOSMComplexKeyNumericValuePropertyTag) OF4OSMTagIdentifier.identifyTag(complexKey, numericValue);
		final IOSMSimpleKeyDateValuePropertyTag simpleKeyDateValuePropertyTag = (IOSMSimpleKeyDateValuePropertyTag) OF4OSMTagIdentifier.identifyTag(simplePropertyKey, dateValue);
		final IOSMComplexKeyDateValuePropertyTag complexKeyDateValuePropertyTag = (IOSMComplexKeyDateValuePropertyTag) OF4OSMTagIdentifier.identifyTag(complexKey, dateValue);
		final IOSMSimpleKeyBooleanValuePropertyTag simpleKeyBooleanValuePropertyTag = (IOSMSimpleKeyBooleanValuePropertyTag) OF4OSMTagIdentifier.identifyTag(simplePropertyKey, booleanValue);
		final IOSMComplexKeyBooleanValuePropertyTag complexKeyBooleanValuePropertyTag = (IOSMComplexKeyBooleanValuePropertyTag) OF4OSMTagIdentifier.identifyTag(complexKey, booleanValue);
		final IOSMMultipleValuePropertyTag multipleValuePropertyTag = (IOSMMultipleValuePropertyTag) OF4OSMTagIdentifier.identifyTag(simplePropertyKey, multipleValue);
		final IOSMTimeDomainsValuePropertyTag timeDomainsValuePropertyTag = (IOSMTimeDomainsValuePropertyTag) OF4OSMTagIdentifier.identifyTag(simplePropertyKey, timeDomains);
	
		assertNotNull(simpleCategoryTag);
		assertNotNull(statefulCategoryTag);
		assertNotNull(multipleCategoryTag);
		
		assertNotNull(simpleKeyStringValuePropertyTag);
		assertNotNull(complexKeyStringValuePropertyTag);
		assertNotNull(localizedKeyStringValuePropertyTag);
		assertNotNull(simpleKeyNumericValuePropertyTag);
		assertNotNull(complexKeyNumericValuePropertyTag);
		assertNotNull(simpleKeyDateValuePropertyTag);
		assertNotNull(complexKeyDateValuePropertyTag);
		assertNotNull(simpleKeyBooleanValuePropertyTag);
		assertNotNull(complexKeyBooleanValuePropertyTag);
		assertNotNull(multipleValuePropertyTag);
		assertNotNull(timeDomainsValuePropertyTag);
		
	}

}
