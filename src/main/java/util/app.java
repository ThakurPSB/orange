package util;

public class app {

	public static String basedir = System.getProperty("user.dir"); // to get the base directory of the project.
	public static String filePath = basedir+ "\\src\\main\\resources\\propertiesFiles\\app.properties";
	
	public static String getAppUrl(String env) {
		return propertiesUtil.getProperty(filePath,env+".url");
	}
	
	public static String getUsername(String env) {
		return propertiesUtil.getProperty(filePath,env+".username");
	}
	
	public static String getPassword(String env) {
		return propertiesUtil.getProperty(filePath,env+".password");
	}
	
	
}
