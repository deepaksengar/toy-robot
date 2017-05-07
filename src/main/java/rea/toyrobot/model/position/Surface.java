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
}