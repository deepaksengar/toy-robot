package rea.toyrobot.builder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import rea.toyrobot.model.position.Coordinate;
import rea.toyrobot.model.position.Surface;

public class SurfaceBuilder {

	private final static Logger logger = Logger.getLogger(SurfaceBuilder.class);

	public static final String COMMA_SEPERATOR = ",";
	InputStream inputStream;

	public Surface buildSurface() throws Exception {

		Coordinate initial;
		Coordinate edge;

		try {

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

			int initialX = 0;
			int initialY = 0;

			int edgeX = Integer.parseInt(length) - 1;
			int edgeY = Integer.parseInt(width) - 1;

			initial = new Coordinate(initialX, initialY);
			edge = new Coordinate(edgeX, edgeY);

			logger.debug("Initialising properties. \nSurface Length = " + length + " \nWidth = " + width);

		} catch (IOException | NumberFormatException ex) {
			ex.printStackTrace();
			logger.error("Cannot initialise Surface. " + ex.getMessage());
			throw ex;
		}

		return new Surface(initial, edge);
	}

}
