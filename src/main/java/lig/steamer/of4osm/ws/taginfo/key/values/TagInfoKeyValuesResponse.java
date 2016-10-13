package lig.steamer.of4osm.ws.taginfo.key.values;

import java.util.List;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponse;

/**
 *
 * @author amehiris
 */
public class TagInfoKeyValuesResponse extends TagInfoResponse {
    
    private List<TagInfoKeyValuesResponseData> data;

    public List<TagInfoKeyValuesResponseData> getData() {
        return data;
    }

    public void setData(List<TagInfoKeyValuesResponseData> data) {
        this.data = data;
    }
    
}
