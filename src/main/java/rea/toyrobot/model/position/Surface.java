package rea.toyrobot.model.position;

public class Surface implements ISurface {
	private Coordinate initialBoundry;
	private Coordinate edgeBoundry;
	
	public Surface(){}

	public Surface(final Coordinate initial, final Coordinate edge) {
		this.initialBoundry = initial;
		this.edgeBoundry = edge;
	}

	public Coordinate getInitialBoundry() {
		return initialBoundry;
	}

	public Coordinate getEdgeBoundry() {
		return edgeBoundry;
	}

	public Surface createSurface(int length, int width) {

		int initialX = 0;
		int initialY = 0;

		int edgeX = length - 1;
		int edgeY = width - 1;

		Coordinate initial = new Coordinate(initialX, initialY);
		Coordinate edge = new Coordinate(edgeX, edgeY);

		return new Surface(initial, edge);
	}
	
	@Override
	public boolean isValidPositionOnSurface(Position newPosition) {
		int initX = this.getInitialBoundry().getX();
		int initY = this.getInitialBoundry().getY();
		int edgeX = this.getEdgeBoundry().getX();
		int edgeY = this.getEdgeBoundry().getY();

		int currentX = newPosition.getCoordinate().getX();
		int currentY = newPosition.getCoordinate().getY();

		if (initX <= currentX && edgeX >= currentX && initY <= currentY && edgeY >= currentY) {
			return true;
		}

		return false;
	}
}