package lig.steamer.of4osm.ws.taginfo;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public final class TagInfoRequest {

	public final static String ENDPOINT = "https://taginfo.openstreetmap.org/api/4/";
	
	public final static String PARAM_KEY = "key";
	public final static String PARAM_VALUE = "value";
	public final static String PARAM_PAGE = "page";
	public final static String PARAM_RP = "rp";
	public final static String PARAM_SORTNAME = "sortname";
	public final static String PARAM_SORTORDER = "sortorder";
	
    public final static int DEFAULT_PAGE = 1;
    public final static int DEFAULT_RP = 100;
    public final static String DEFAULT_SORTORDER = "asc";
	
}
