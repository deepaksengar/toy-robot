package rea.toyrobot.tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import rea.toyrobot.errorutility.IllegalDirectionArgument;
import rea.toyrobot.errorutility.IllegalTaskArgument;
import rea.toyrobot.model.position.Direction;
import rea.toyrobot.model.position.Position;

public class Place implements ICommand<Position> {

	private final static Logger logger = Logger.getLogger(Place.class);

	private Position position;

	private static final Pattern PLACE_COMMAND_REGEX = Pattern.compile(Tasks.PLACE.name() + "[\\s]+(\\d+)[\\s]*,[\\s]*(\\d+)[\\s]*,[\\s]*(\\w+)[\\s]*");

	public Place(int x, int y, Direction direction) {
		this(new Position(x, y, direction));
	}

	public Position getPosition(int x, int y, Direction direction) {
		return new Position(x, y, direction);
	}

	public Place(Position position) {
		this.position = position;
	}

	public Place(String position) {
		this.position = parsePlaceCommand(position);
	}

	@Override
	public Position execute(Position position) {
		return this.getPosition() == null ? position : this.getPosition();
	}

	public Position execute(String position) {
		parsePlaceCommand(position);
		return this.getPosition();
	}

	public Position getPosition() {
		return position;
	}

	private Position parsePlaceCommand(String commandStr) {
		debugLog("Parsing PLACE command : " + commandStr);
		
		Matcher matcher = PLACE_COMMAND_REGEX.matcher(commandStr);

		if (matcher.matches()) {
			return placeCommand(matcher);
		}

		return this.position;
	}

	private Position placeCommand(Matcher matcher) {
		debugLog("Position : " + matcher.group(1) + "," + matcher.group(2) + "," + matcher.group(3));
		try {
			return getPosition(Integer.parseInt(matcher.group(1).trim().toUpperCase()), Integer.parseInt(matcher.group(2).trim()),
					this.parseDirection(matcher.group(3).trim().toUpperCase()));
		} catch (IllegalDirectionArgument | IllegalTaskArgument | NullPointerException ex) {
			errorLog(ex.getMessage());
			throw ex;
		}
	}

	public Direction parseDirection(String directionStr) throws IllegalArgumentException {
		debugLog("Direction : " + directionStr);
		return Direction.valueOf(directionStr);
	}

	private void errorLog(String message) {
		logger.error(message);
	}

	private void debugLog(String message) {
		logger.debug(message);
	}

}
