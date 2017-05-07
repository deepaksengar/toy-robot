package rea.toyrobot.errorutility;

public class IllegalPlaceArgument extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalPlaceArgument() {
		this("Illegal Place command.");
	}

	public IllegalPlaceArgument(String message) {
		super(message);
	}

}
