package com.metacube.shoppingApp.dao;

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

	public Properties ReadFile() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("C:\\Users\\Admin\\workspace\\EADsession5\\PropertiesFile\\dbconfig.properties");
		
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

}
