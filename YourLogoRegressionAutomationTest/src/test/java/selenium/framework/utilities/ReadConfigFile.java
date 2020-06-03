package selenium.framework.utilities;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
Properties prop;
	
	public ReadConfigFile()
	{
		try {
			
			prop = new Properties();
			InputStream in= getClass().getClassLoader().getResourceAsStream("selenium/framework/resources/config.properties");
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

}
