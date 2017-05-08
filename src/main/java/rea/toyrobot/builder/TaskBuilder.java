package rea.toyrobot.builder;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import rea.toyrobot.errorutility.IllegalDirectionArgument;
import rea.toyrobot.errorutility.IllegalTaskArgument;
import rea.toyrobot.model.position.Direction;
import rea.toyrobot.tasks.EmptyCommand;
import rea.toyrobot.tasks.ICommand;
import rea.toyrobot.tasks.Left;
import rea.toyrobot.tasks.Move;
import rea.toyrobot.tasks.Tasks;
import rea.toyrobot.tasks.Place;
import rea.toyrobot.tasks.Report;
import rea.toyrobot.tasks.Right;

public class TaskBuilder implements Function<String, ICommand> {
	private final static Logger logger = Logger.getLogger(TaskBuilder.class);

	private static final Pattern PLACE_COMMAND_REGEX = Pattern
			.compile(Tasks.PLACE.name() + " (\\d+),(\\d+),(\\w+)");
	private static Pattern whitespace = Pattern.compile("\\s\\s");

	/**
	 * Turn an input command string into a command object.
	 * 
	 * @param commandStr
	 * @return The corresponding command object or a empty-command
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ICommand apply(String commandStr) {
		if (commandStr == null || commandStr.isEmpty()) {
			errorLog("Null or Empty Command.");
			return new EmptyCommand();
		} else if (commandStr.equals(Tasks.LEFT.name())) {
			return new Left();
		} else if (commandStr.equals(Tasks.MOVE.name())) {
			return new Move();
		} else if (commandStr.startsWith(Tasks.PLACE.name())) {
			return this.parsePlaceCommand(commandStr);
		} else if (commandStr.equals(Tasks.REPORT.name())) {
			return new Report();
		} else if (commandStr.equals(Tasks.RIGHT.name())) {
			return new Right();
		} else {
			errorLog("Illegal command: " + commandStr + " . Not executing.");
			return new EmptyCommand();
		}
	}

	@SuppressWarnings("rawtypes")
	private ICommand parsePlaceCommand(String commandStr) {
		debugLog("Parsing PLACE command : " + commandStr);
		Matcher spaceMatcher = whitespace.matcher(commandStr);
		Matcher matcher = PLACE_COMMAND_REGEX.matcher(commandStr);
		if (matcher.matches()) {
			return placeCommand(matcher);
		} else {
			errorLog("Illegal PLACE command: " + commandStr + " . Not executing.");
			return new EmptyCommand();
		}
	}

	@SuppressWarnings("rawtypes")
	private ICommand placeCommand(Matcher matcher) {
		debugLog("Position : " + matcher.group(1) + "," + matcher.group(2) + "," + matcher.group(3));
		try {
			return new Place(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)),
					this.parseDirection(matcher.group(3)));
		} catch (IllegalDirectionArgument | IllegalTaskArgument | NullPointerException ex) {
			errorLog(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			errorLog(ex.getMessage());
			throw ex;
		}
	}

	private Direction parseDirection(String directionStr) {
		debugLog("Direction : " + directionStr);
		if (directionStr == null || directionStr.isEmpty()) {
			errorLog("Direction is Null or Empty.");
			throw new IllegalDirectionArgument("Empty Direction.");
		} else if (directionStr.equals(Direction.NORTH.name())) {
			return Direction.NORTH;
		} else if (directionStr.equals(Direction.EAST.name())) {
			return Direction.EAST;
		} else if (directionStr.equals(Direction.SOUTH.name())) {
			return Direction.SOUTH;
		} else if (directionStr.equals(Direction.WEST.name())) {
			return Direction.WEST;
		} else {
			errorLog("Illegal Direction: " + directionStr);
			throw new IllegalDirectionArgument("Illegal Direction: " + directionStr);
		}
	}

	private void errorLog(String message) {
		logger.error(message);
	}

	private void debugLog(String message) {
		logger.debug(message);
	}
}
