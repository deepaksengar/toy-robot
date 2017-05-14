package rea.toyrobot.model.robot;

import org.apache.log4j.Logger;

import rea.toyrobot.model.position.Position;
import rea.toyrobot.model.position.Surface;
import rea.toyrobot.model.status.Status;
import rea.toyrobot.tasks.ICommand;
import rea.toyrobot.tasks.Tasks;

public class Robot implements IRobot {

	private final static Logger logger = Logger.getLogger(Robot.class);

	private Status status = Status.IDLE;
	private Position position;
	private final Surface surface;

	public Robot(Surface surface) {
		this.surface = surface;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public void doTask(ICommand command) {
		// In case of Place command set Status Running.
		if (command.getClass().getSimpleName().equalsIgnoreCase(Tasks.PLACE.name())) {
			this.setStatus(Status.RUNNING);
		}

		if (this.status == Status.IDLE) {
			logger.debug("Robot is " + this.status.name() + " . Cannot do Task.");
			return;
		}

		this.setPosition((Position) command.execute(this.getPosition()));
	}
	
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		if (!this.surface.isValidPositionOnSurface(position)) {
			logger.error("Incorrect Position : " + position + " on Surface. Not setting wrong position.");
			return;
		}

		this.position = position;
	}

	public Surface getSurface() {
		return this.surface;
	}
}
