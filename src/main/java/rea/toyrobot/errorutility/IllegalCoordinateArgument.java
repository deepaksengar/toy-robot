package rea.toyrobot.errorutility;

public class IllegalCoordinateArgument extends RuntimeException {

	/**
	 * Default Version Id for serializable class.
	 */
	private static final long serialVersionUID = 1L;

	public IllegalCoordinateArgument() {
		this("Cannot go to provided Coordinate");
	}

	public IllegalCoordinateArgument(String message) {
		super(message);
	}

}
