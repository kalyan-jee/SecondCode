package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass {
	
	public String readConfig(String str) throws FileNotFoundException
	{
		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/config.properties"));
		Properties prop = new Properties();
		try {
			prop.load(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = prop.getProperty(str);
		return value;
		
	}

}
