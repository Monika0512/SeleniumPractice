package util;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	public ConfigReader()
	{
		try {
			
			File src = new File("./Main/propertyfile/propertyFile.property");
			FileInputStream fs = new FileInputStream(src);
			
			prop = new Properties();
			prop.load(fs);
						
		}
		
				catch(Exception e){
			
			e.printStackTrace();
		}
}
	
	public String getservicestring() {
		return prop.getProperty("servicestring");
	}

	public String getUrl() {
		return prop.getProperty("url");
		
	}
}
