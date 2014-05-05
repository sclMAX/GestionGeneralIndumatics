package max.clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class abmProperties {
	private static String appConfigFile = "appconfig.properties";
	
	public static String getPropertie (String key)
	{
		String result = null;
		try {
			InputStream is = new FileInputStream(appConfigFile);
			Properties appProperties = new Properties();
			appProperties.load(is);
			result = appProperties.getProperty(key);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void setPropertie (String key, String value) throws IOException
	{
			InputStream is = new FileInputStream(appConfigFile);
			Properties appProperties = new Properties();
			appProperties.load(is);
			appProperties.setProperty(key, value);
			appProperties.store(new FileOutputStream(appConfigFile), "");		
	}

}
