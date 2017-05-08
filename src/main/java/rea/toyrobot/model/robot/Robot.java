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
		if (this.status == Status.RUNNING) {
			this.setPosition((Position) command.execute(this.getPosition()));
		} else {
			logger.debug("Robot is " + this.status.name() + " . Cannot do Task.");
		}
	}

	private boolean isValidPosition(Position newPosition) {
		int initX = this.getSurface().getInitialBoundry().getX();
		int initY = this.getSurface().getInitialBoundry().getY();
		int edgeX = this.getSurface().getEdgeBoundry().getX();
		int edgeY = this.getSurface().getEdgeBoundry().getY();

		int currentX = newPosition.getCoordinate().getX();
		int currentY = newPosition.getCoordinate().getY();

		if (initX <= currentX && edgeX >= currentX && initY <= currentY && edgeY >= currentY) {
			return true;
		}

		return false;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		if (isValidPosition(position)) {
			this.position = position;
		} else {
			logger.error("Incorrect Position : " + position + " . Going out of Surface. Not setting wrong position.");
		}
	}

	public Surface getSurface() {
		return surface;
	}

}
