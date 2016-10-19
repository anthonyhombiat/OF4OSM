package lig.steamer.of4osm.core.folkso.tag.key.impl;

import lig.steamer.of4osm.core.folkso.tag.key.IOSMTagLocalizedKey;

/**
 *
 * @author amehiris
 */
public class OSMTagLocalizedKey extends OSMTagKey implements IOSMTagLocalizedKey {

    private String locale;

    public OSMTagLocalizedKey(String value, String wikiURL) {
        super(value, wikiURL);
        String[] values = value.split(":");
        this.value = values[0];
        this.locale = values[1];
    }

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public String toString() {
        return value + ":" + locale;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		OSMTagLocalizedKey other = (OSMTagLocalizedKey) obj;
		
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		
		return true;
	}

}
