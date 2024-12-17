package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadingDataFromPropertiesFile {
	public String readDataFromFile(String key) throws Exception {
		FileInputStream fis=new FileInputStream("./src/main/resources/DWS_CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		return prop.getProperty(key);
	}
}
