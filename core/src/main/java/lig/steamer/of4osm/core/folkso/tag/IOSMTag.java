package lig.steamer.of4osm.core.folkso.tag;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagKey;
import lig.steamer.of4osm.core.folkso.tag.value.IOSMTagValue;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMTag {

	/**
	 * Gets the IOSMTag URL of the corresponding page on the OSM wiki.
	 * The URL is the identifier of the IOSMTag.
	 * @return the URL.
	 */
	public String getWikiURL();
	
	/**
	 * Gets the IOSMTagKey that refers to the left part of
	 * the <key>=<value> in the IOSMTag format.
	 * @return the IOSMTagKey.
	 */
	public IOSMTagKey getKey();

	/**
	 * Gets the IOSMTagValue that refers to the right part of
	 * the <key>=<value> in the IOSMTag format.
	 * @return the IOSMTagKey.
	 */
	public IOSMTagValue getValue();

}