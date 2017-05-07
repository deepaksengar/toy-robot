package rea.toyrobot.errorutility;

public class IllegalDirectionArgument extends RuntimeException {

	/**
	 * Default Version Id for serializable class.
	 */
	private static final long serialVersionUID = 1L;

	public IllegalDirectionArgument() {
		this("Unknown Direction.");
	}

	public IllegalDirectionArgument(String message) {
		super(message);
	}

}
