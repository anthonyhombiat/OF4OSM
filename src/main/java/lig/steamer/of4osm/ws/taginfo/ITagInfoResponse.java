package lig.steamer.of4osm.ws.taginfo;

import java.util.List;

/**
 * 
 * @author Anthony Hombiat
 *
 */
public interface ITagInfoResponse {

	public String getUrl();
	public void setUrl(String url);

    public String getData_until();
    public void setData_until(String data_until);
    
    public int getPage();
    public void setPage(int page);
    
    public int getRp();
    public void setRp(int rp);
    
    public int getTotal();
    public void setTotal(int total);
   
    public List<? extends TagInfoResponseData> getData();
	
}
