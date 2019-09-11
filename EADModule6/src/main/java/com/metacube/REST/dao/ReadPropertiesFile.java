package com.metacube.REST.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class is used for read properties file.
 */

public class ReadPropertiesFile {

	public Properties readFile() throws IOException {

		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("C:\\Users\\Admin\\workspace\\REST\\PropertiesFile\\dbconfig.properties");	
		prop.load(input);
		return prop;
	}

}
