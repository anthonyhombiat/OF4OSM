package lig.steamer.of4osm.folkso.tag.component;

import java.util.Date;

/**
 * 
 */
public interface IOSMTagDateIntervalValue extends IOSMTagDateValue {

    /**
     * @return
     */
    public Date getBinf();

    /**
     * @return
     */
    public Date getBsup();

}