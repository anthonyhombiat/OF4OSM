package lig.steamer.of4osm.tools;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FilenameUtils;

public class PropLoader {

	public static final String PROP_FILENAME = "config.properties";
	
	String result;
	InputStream inputStream;
	
	public PropLoader(){
		
	}
	
	public String getProp(String propKey){
		
		Properties prop = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(PROP_FILENAME);
		result = "";
		
		try {
			
			if (inputStream != null) {
				prop.load(inputStream);
				result = prop.getProperty(propKey);
				inputStream.close();
			} else {
				inputStream.close();
				throw new FileNotFoundException("property file '" + PROP_FILENAME + "' not found in the classpath");
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String getPath(){
		URL url = getClass().getClassLoader().getResource(PROP_FILENAME);
		return FilenameUtils.getPath(url.toString());
	}
	
}
