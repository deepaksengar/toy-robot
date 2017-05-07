package rea.toyrobot.model.position;

import rea.toyrobot.errorutility.IllegalDirectionArgument;

public enum Direction {

	EAST, WEST, NORTH, SOUTH;

	public Direction left() {
		switch (this) {
		case NORTH:
			return WEST;
		case EAST:
			return NORTH;
		case SOUTH:
			return EAST;
		case WEST:
			return SOUTH;
		default:
			throw new IllegalDirectionArgument("Unknown Direction : " + this);
		}
	}

	public Direction right() {
		switch (this) {
		case NORTH:
			return EAST;
		case EAST:
			return SOUTH;
		case SOUTH:
			return WEST;
		case WEST:
			return NORTH;
		default:
			throw new IllegalDirectionArgument("Orientation unknown: " + this);
		}
	}

}
