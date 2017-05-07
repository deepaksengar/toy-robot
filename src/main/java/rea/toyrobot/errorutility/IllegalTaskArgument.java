package rea.toyrobot.errorutility;

public class IllegalTaskArgument extends RuntimeException {

	/**
	 * Default Version Id
	 */
	private static final long serialVersionUID = 1L;

	public IllegalTaskArgument() {
		this("Unknown Task. This task is not supported.");
	}

	public IllegalTaskArgument(String message) {
		super(message);
	}

}
