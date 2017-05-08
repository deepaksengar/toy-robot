package implementation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import rea.toyrobot.RobotExecutor;
import rea.toyrobot.model.robot.Robot;

public class RobotExecutorTest {

	private RobotExecutor robotExecutor;

	@Before
	public void setUp() {
		this.robotExecutor = new RobotExecutor();
	}

	@Test
	public void testInput1() throws Exception {
		String[] commands = { "PLACE 0,0,NORTH", "MOVE", "REPORT" };
		robotExecutor.run(Arrays.asList(commands));

		assertEquals("0,1,NORTH", ((Robot) robotExecutor.getRobot()).getPosition().toString());
	}

	@Test
	public void testInput2() throws Exception {
		String[] commands = { "PLACE 0,0,NORTH", "LEFT", "REPORT" };
		robotExecutor.run(Arrays.asList(commands));
		assertEquals("0,0,WEST", ((Robot) robotExecutor.getRobot()).getPosition().toString());
	}

	@Test
	public void testInput3C() throws Exception {
		String[] commands = { "PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT" };
		robotExecutor.run(Arrays.asList(commands));
		assertEquals("3,3,NORTH", ((Robot) robotExecutor.getRobot()).getPosition().toString());
	}

	@Test
	public void testFileInput() throws Exception {
		final String path = getClass().getClassLoader().getResource("testCommands.txt").getPath();
		final String[] args = new String[] { path };

		RobotExecutor.executeSimulator(args);
	}
}
