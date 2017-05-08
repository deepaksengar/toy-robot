package rea.toyrobot.tasks;

import rea.toyrobot.model.position.Direction;
import rea.toyrobot.model.position.Position;

public class Place implements ICommand<Position> {

	private Position position;

	public Place(int x, int y, Direction direction) {
		this(new Position(x, y, direction));
	}

	public Place(Position position) {
		this.position = position;
	}

	public Place() {
	}

	@Override
	public Position execute(Position position) {
		// if (position == null)
		return this.getPosition();
		// else
		// return position;
	}

	public Position getPosition() {
		return position;
	}

}
