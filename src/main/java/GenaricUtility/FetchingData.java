package GenaricUtility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class FetchingData {
	public String FetchingDatafromPropertiesFile(String key) throws Throwable {
		File file=new File("./src/test/resources/Mypropertyfile.properties");
		FileInputStream fileinputstream=new FileInputStream(file);
		Properties property=new Properties();
		property.load(fileinputstream);
		
		String value = property.getProperty(key);
		return value;
		
	}

}
