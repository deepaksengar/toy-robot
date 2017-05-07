package rea.toyrobot.model.position;

public class Coordinate {

	private final int x;
	private final int y;

	public Coordinate(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return this.getX() + "," + this.getY();
	}
}
