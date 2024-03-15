package commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class PropertyFileUtil {

	public String getDataFromPropertyFile(String keyname) throws IOException {
		FileInputStream file=new FileInputStream("src\\test\\resources\\LoginCredential.properties");
		Properties properties=new Properties();
		properties.load(file);
		String value=properties.getProperty(keyname);
		return value;
		
	}
}
