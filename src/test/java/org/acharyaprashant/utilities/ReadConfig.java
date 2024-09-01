package org.acharyaprashant.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static Properties pro;
	//static Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream (src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Expection is " + e.getMessage());
		}	
	}
	
	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUserId() {
		String uid = pro.getProperty("userId");
		return uid;
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	
	
	
	
}
