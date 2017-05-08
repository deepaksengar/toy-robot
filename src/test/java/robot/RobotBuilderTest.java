package robot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import rea.toyrobot.builder.RobotBuilder;
import rea.toyrobot.builder.TaskBuilder;
import rea.toyrobot.model.robot.IRobot;
import rea.toyrobot.model.status.Status;

public class RobotBuilderTest {

	private IRobot robot;
	private TaskBuilder taskBuilder;

	@Before
	public void setUp() throws Exception {
		this.robot = new RobotBuilder().buildRobot();
		taskBuilder = new TaskBuilder();
	}

	@Test
	public void testStatus() throws Exception {
		Status status = this.robot.getStatus();
		assertEquals("Initial Status of Robot should be IDLE.", Status.IDLE, status);
	}

	@Test
	public void testStatusRunning() throws Exception {
		this.robot.doTask(taskBuilder.apply("PLACE 0,0,EAST"));
		Status status = this.robot.getStatus();
		assertEquals("After Place Task, Robot status should be RUNNING.", Status.RUNNING, status);
	}

	@Test
	public void testExecutingTasks() throws Exception {
		try {
			this.robot.doTask(taskBuilder.apply("PLACE 0,0,EAST"));
			this.robot.doTask(taskBuilder.apply("RIGHT"));
			this.robot.doTask(taskBuilder.apply("MOVE"));
			this.robot.doTask(taskBuilder.apply("LEFT"));
			this.robot.doTask(taskBuilder.apply("MOVE"));
			this.robot.doTask(taskBuilder.apply("REPORT"));
		} catch (Exception ex) {
			fail("Not executing some tasks");
		}
	}

	@Test
	public void testExecutingTasksWithoutPlace() throws Exception {
		try {
			this.robot.doTask(taskBuilder.apply("RIGHT"));
			this.robot.doTask(taskBuilder.apply("MOVE"));
			this.robot.doTask(taskBuilder.apply("LEFT"));
			this.robot.doTask(taskBuilder.apply("MOVE"));
			this.robot.doTask(taskBuilder.apply("REPORT"));
			assertEquals("Status of Robot should be IDLE without Executing Place command.", Status.IDLE,
					this.robot.getStatus());
		} catch (Exception ex) {
			fail("Not executing some tasks");
		}

	}

}
