package rea.toyrobot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import rea.toyrobot.builder.RobotBuilder;
import rea.toyrobot.builder.TaskBuilder;
import rea.toyrobot.model.robot.IRobot;

public class RobotExecutor {

	private final static Logger logger = Logger.getLogger(RobotExecutor.class);

	private IRobot robot;

	public RobotExecutor() {
		this.setRobot(new RobotBuilder().buildRobot());
	}

	public static void main(String[] args) {
		try {
			executeSimulator(args);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	public void run(List<String> commands) {
		TaskBuilder taskBuilder = new TaskBuilder();

		commands.forEach(command -> {
			this.getRobot().doTask(taskBuilder.apply(command));
		});
	}

	public static void executeSimulator(String[] args) throws Exception {
		RobotExecutor executor = new RobotExecutor();

		if (executor.getRobot() == null) {
			throw new Exception("Initialisation Error. Could not Initialise Surface/Robot.");
		}

		List<String> commands;
		
		switch(args.length){
			case 1 : commands = fileInput(args[0]);
					break;
			default :
					commands = consoleInput();
		}
		
		commands = commands.stream().filter(s-> !s.isEmpty())
					.map(s->s.trim().toUpperCase()).collect(Collectors.toList());
		
		executor.run(commands);
	}

	
	private static List<String> fileInput(String path) {
		try {
			return Files.lines(Paths.get(path)).collect(Collectors.toList());
		} catch (IOException ex) {
			logger.error("Could not read input from file : " + path + " . " + ex.getMessage());
			return new ArrayList<>();
		}
	}

	private static List<String> consoleInput() {
		
		List<String> result = new ArrayList<>();

		System.out.println("Toy Robot...");
		System.out.println("To see final result enter REPORT.");
		System.out.println("Please enter commands:");
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				String inputStr = scanner.nextLine();
				result.add(inputStr);

				if ("Report".equalsIgnoreCase(inputStr))
					break;
			}
		}
		
		return result;
	}

	public IRobot getRobot() {
		return robot;
	}

	public void setRobot(IRobot robot) {
		this.robot = robot;
	}
}
