package rea.toyrobot.tasks;

import rea.toyrobot.model.position.Direction;
import rea.toyrobot.model.position.Position;

public class Left implements ICommand<Position> {
	
	public Direction getLeftDirection(Direction direction) {
		switch (direction) {
		
		case NORTH:
			return Direction.WEST;
		case EAST:
			return Direction.NORTH;
		case SOUTH:
			return Direction.EAST;
		
		case WEST:
			return Direction.SOUTH;
		
		default:
			return direction;
		}
	}

	@Override
	public Position execute(Position position) {
		return new Position(position.getCoordinate(), getLeftDirection(position.getDirection()));
	}
}
