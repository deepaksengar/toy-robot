package rea.toyrobot.tasks;

import rea.toyrobot.errorutility.IllegalDirectionArgument;
import rea.toyrobot.model.position.Direction;
import rea.toyrobot.model.position.Position;

public class Move implements ICommand<Position> {

	@Override
	public Position execute(Position position) {

		int newX = position.getCoordinate().getX();
		int newY = position.getCoordinate().getY();
		Direction direction = position.getDirection();

		switch (direction) {
		case NORTH:
			newY += 1;
			break;
		case EAST:
			newX += 1;
			break;
		case SOUTH:
			newY -= 1;
			break;
		case WEST:
			newX -= 1;
			break;
		default:
			throw new IllegalDirectionArgument("Unknown Direction. Could not Move for direction : " + direction);
		}

		return new Position(newX, newY, direction);
	}

}
