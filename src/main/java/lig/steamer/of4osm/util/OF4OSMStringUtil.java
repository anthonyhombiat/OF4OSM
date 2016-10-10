package lig.steamer.of4osm.util;

import org.apache.commons.lang3.text.WordUtils;

public final class OF4OSMStringUtil {

	public static String normalize(String s){
		String res = WordUtils.capitalize(s);
		res = WordUtils.capitalize(res, '_');
		res = res.replace(" ", "");
		res = res.replace("_", "");
		return res;
	}
	
}
