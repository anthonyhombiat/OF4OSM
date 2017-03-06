package lig.steamer.of4osm.core.folkso.tag.key;

/**
 *
 * @author amehiris
 */
public interface IOSMTagLocalizedKey extends IOSMTagKey {

	/**
	 * Gets the String representation of the locale in the IOSMTagLocalizedKey.
	 * @return the String
	 */
    public String getLocale();
}