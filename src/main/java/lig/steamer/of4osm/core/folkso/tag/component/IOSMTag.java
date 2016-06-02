package lig.steamer.of4osm.core.folkso.tag.component;


/**
 * 
 */
public interface IOSMTag {



    /**
     * @return
     */
    public IOSMTagKey getKey();

    /**
     * @return
     */
    public IOSMTagValue getValue();

    /**
     * @return
     */
    public String getWikiURL();

}