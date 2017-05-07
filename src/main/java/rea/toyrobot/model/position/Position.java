package rea.toyrobot.model.position;

public class Position {

	private final Direction direction;
	private final Coordinate coordinate;

	public Position(final int x, int y, final Direction direction) {
		this.direction = direction;
		this.coordinate = new Coordinate(x, y);
	}

	public Position(Coordinate coordinate, Direction direction) {
		this.direction = direction;
		this.coordinate = coordinate;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public Coordinate getCoordinate() {
		return this.coordinate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Position)) {
			return false;
		}
		if (this == obj) {
			return true;
		}

		Position pos = (Position) obj;
		return this.getDirection() == pos.getDirection() && this.getCoordinate().equals(pos.getCoordinate());
	}

	@Override
	public String toString() {
		return this.getCoordinate() + "," + this.getDirection();
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + (this.getCoordinate() != null
				? this.getCoordinate().getX() * 3 + this.getCoordinate().getY() * 5 : 0);
		result = prime * result + (this.getDirection() != null ? this.getDirection().ordinal() * 13 : 0);
		return result;
	}

}
