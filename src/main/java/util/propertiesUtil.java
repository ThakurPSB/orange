package util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtil {
	
	public static String getProperty(String filepath, String key)  {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	public static String getLocator(String key) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("C:\\Users\\piyus\\eclipse-workspace\\OHRM\\src\\main\\resources\\propertiesFiles\\locators.properties");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch(IOException e	) {
			e.printStackTrace();
		}
		String s =  prop.getProperty(key);
		return s;
	}
}
