package rea.toyrobot.builder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import rea.toyrobot.model.position.Surface;

public class SurfaceBuilder {

	private final static Logger logger = Logger.getLogger(SurfaceBuilder.class);

	public static final String COMMA_SEPERATOR = ",";
	InputStream inputStream;

	public Surface buildSurface() throws Exception {

		Properties prop = new Properties();
		String propFileName = "config.properties";

		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("Property file <" + propFileName + "> not found.");
		}

		// read property value from config file and create Surface
		String length = prop.getProperty("length");
		String width = prop.getProperty("width");

		logger.debug("Initialising properties. \nSurface Length = " + length + " \nWidth = " + width);

		return Surface.createSurface(Integer.parseInt(length), Integer.parseInt(width));
	}
}
