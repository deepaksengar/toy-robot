package rea.toyrobot.builder;

import java.util.function.Function;

import org.apache.log4j.Logger;

import rea.toyrobot.tasks.EmptyCommand;
import rea.toyrobot.tasks.ICommand;
import rea.toyrobot.tasks.Tasks;

public class TaskBuilder implements Function<String, ICommand<?>> {
	private final static Logger logger = Logger.getLogger(TaskBuilder.class);

	private static final String SPACE_SEPARATOR = "\\s";

	/**
	 * Turn an input command string into a command object.
	 * 
	 * @param commandStr
	 * @return The corresponding command object or a empty-command
	 */
	@Override
	public ICommand<?> apply(String commandStr) {
		String command = commandStr.split(SPACE_SEPARATOR)[0];

		try {
			return Tasks.valueOf(command).getCommand(commandStr);
		} catch (IllegalArgumentException ex) {
			errorLog("Illegal command: " + commandStr + " . Not executing.");
			return new EmptyCommand<>();
		}
	}

	private void errorLog(String message) {
		logger.error(message);
	}
}
