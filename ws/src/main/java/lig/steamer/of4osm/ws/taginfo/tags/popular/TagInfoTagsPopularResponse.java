package lig.steamer.of4osm.ws.taginfo.tags.popular;

import java.util.List;

import lig.steamer.of4osm.ws.taginfo.TagInfoResponse;

/**
 *
 * @author amehiris
 */
public class TagInfoTagsPopularResponse extends TagInfoResponse {

    private List<TagInfoTagsPopularResponseData> data;
    
    public List<TagInfoTagsPopularResponseData> getData() {
        return data;
    }

    public void setData(List<TagInfoTagsPopularResponseData> data) {
        this.data = data;
    }
    
}
