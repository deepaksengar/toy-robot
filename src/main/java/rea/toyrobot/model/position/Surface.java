package rea.toyrobot.model.position;

public class Surface {
	private final Coordinate initialBoundry;
	private final Coordinate edgeBoundry;
	private Position position;

	public Surface(final Coordinate initial, final Coordinate edge) {
		this.initialBoundry = initial;
		this.edgeBoundry = edge;
	}

	public Surface(final Coordinate initial, final Coordinate edge, final Position position) {
		this.initialBoundry = initial;
		this.edgeBoundry = edge;
		this.position = position;
	}

	public Coordinate getInitialBoundry() {
		return initialBoundry;
	}

	public Coordinate getEdgeBoundry() {
		return edgeBoundry;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public static Surface createSurface(int length, int width) {

		int initialX = 0;
		int initialY = 0;

		int edgeX = length - 1;
		int edgeY = width - 1;

		Coordinate initial = new Coordinate(initialX, initialY);
		Coordinate edge = new Coordinate(edgeX, edgeY);

		return new Surface(initial, edge);
	}
}