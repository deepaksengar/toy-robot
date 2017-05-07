package rea.toyrobot.tasks;

import rea.toyrobot.errorutility.IllegalTaskArgument;
import rea.toyrobot.model.position.Position;

public enum Tasks {
	PLACE, MOVE, LEFT, RIGHT, REPORT;

	public ICommand<Position> executeTask() {

		switch (this) {
		case PLACE:
			return new Place();
		case MOVE:
			return new Move();
		case LEFT:
			return new Left();
		case RIGHT:
			return new Right();
		case REPORT:
			return new Report();

		default:
			throw new IllegalTaskArgument("Illegal Command. Could not execute command : " + this.name());
		}
	}
}
