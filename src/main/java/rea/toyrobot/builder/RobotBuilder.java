package rea.toyrobot.builder;

import org.apache.log4j.Logger;

import rea.toyrobot.RobotExecutor;
import rea.toyrobot.model.position.ISurface;
import rea.toyrobot.model.robot.IRobot;
import rea.toyrobot.model.robot.Robot;

public class RobotBuilder {

	private final static Logger logger = Logger.getLogger(RobotExecutor.class);

	public IRobot buildRobot() {
		try {
			ISurface surface = new SurfaceBuilder().buildSurface();
			return new Robot(surface);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}
}
