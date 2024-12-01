package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	private static Properties properties;

	private final String configFilePath = System.getProperty("user.dir") + "//integration-tests.properties";

//	public static void main(String[] args) {
//		PropertiesFileReader fileReader= new PropertiesFileReader();
//		System.out.println(fileReader.getProperty("dev.base.url"));
//	}

	public String getProperty(String key) {
		String value = properties.getProperty(key);
		if (value != null)
			return value;
		else
			throw new RuntimeException(key+" not specified in the properties file.");
	}

	public PropertiesFileReader() {
		File ConfigFile = new File(configFilePath);
		try {
			FileInputStream configFileReader = new FileInputStream(ConfigFile);
			properties = new Properties();
			try {
				properties.load(configFileReader);
				configFileReader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("config.properties not found at config file path " + configFilePath);
		}
	}
}
