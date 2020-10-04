package selenium.framework.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
Properties prop;
	
	public ReadConfigFile(String file)
	{
		try {
			
			prop = new Properties();
			//InputStream in= getClass().getClassLoader().getResourceAsStream("resources/"+file);
			FileInputStream in =new FileInputStream(System.getProperty("user.dir")+"/src/test/java/resources/"+file);
			prop.load(in);
			
			if(prop==null)
			{
				System.out.println("Prop is null");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public String getApplicationURL() {
		
		String url= prop.getProperty("baseURL");
		return url;
		
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getbrowser()
	{
		String browser = prop.getProperty("browser");
		return browser;
	}
	
	public String getCustomerId()
	{
		String customerId=prop.getProperty("customerId");
		return customerId;
	}

	public String gettopnav1() {
		String topnav1= prop.getProperty("topNavigation1");
		return topnav1;
	}
	
	public String gettopnav2() {
		String topnav2= prop.getProperty("topNavigation2");
		return topnav2;
	}
	
	public String gettopnav3() {
		String topnav3= prop.getProperty("topNavigation3");
		return topnav3;
	}

	public String getProductUrl(String key) {
		String url = prop.getProperty(key);
		return url;
	}

	public String getProductSize(String key) {
		String size = prop.getProperty(key);
		return size;
	}
	
	public String getProductColour(String key) {
		String colour = prop.getProperty(key);
		return colour;
	}
	

}
