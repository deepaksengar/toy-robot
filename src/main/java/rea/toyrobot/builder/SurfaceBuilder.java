package rea.toyrobot.builder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import rea.toyrobot.model.position.ISurface;
import rea.toyrobot.model.position.Surface;

public class SurfaceBuilder {

	private final static Logger logger = Logger.getLogger(SurfaceBuilder.class);

	public static final String COMMA_SEPERATOR = ",";

	public ISurface buildSurface() throws Exception {

		Properties prop = readProperties();

		// read property value from config file and create Surface
		String length = prop.getProperty("length");
		String width = prop.getProperty("width");

		logger.debug("Initialising properties. \nSurface Length = " + length + " \nWidth = " + width);

		return new Surface().createSurface(Integer.parseInt(length), Integer.parseInt(width));
	}

	private Properties readProperties() throws IOException, FileNotFoundException {
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("Property file <" + propFileName + "> not found.");
		}
		return prop;
	}
}
