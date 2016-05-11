package lig.steamer.of4osm.folkso.tag.component;


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