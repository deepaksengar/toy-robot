package rea.toyrobot.tasks;

import rea.toyrobot.model.position.Direction;
import rea.toyrobot.model.position.Position;

public class Right implements ICommand<Position> {
	
	public Direction getRightDirection(Direction direction) {
		switch (direction) {
			case NORTH:
				return Direction.EAST;
			case EAST:
				return Direction.SOUTH;
			case SOUTH:
				return Direction.WEST;
			case WEST:
				return Direction.NORTH;
			default:
				return direction;
		}
	}

	@Override
	public Position execute(Position position) {
		return new Position(position.getCoordinate(), getRightDirection(position.getDirection()));
	}
}
