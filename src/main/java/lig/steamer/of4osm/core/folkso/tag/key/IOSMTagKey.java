package lig.steamer.of4osm.core.folkso.tag.key;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface IOSMTagKey {

	/**
	 * Gets the String that correspond to the IOSMTagKey URL on the OSM wiki. 
	 * @return the String
	 */
	public String getWikiURL();
	
	/**
	 * Gets the String respresentation of the key.
	 * @return the String
	 */
    public String getValue();

}
