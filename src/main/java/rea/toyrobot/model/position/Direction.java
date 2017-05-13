package rea.toyrobot.model.position;

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
			return this;
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
			return this;
		}
	}

}
