package task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import rea.toyrobot.builder.TaskBuilder;
import rea.toyrobot.model.position.Direction;
import rea.toyrobot.model.position.Position;
import rea.toyrobot.tasks.ICommand;
import rea.toyrobot.tasks.Left;
import rea.toyrobot.tasks.Move;
import rea.toyrobot.tasks.Place;
import rea.toyrobot.tasks.Report;
import rea.toyrobot.tasks.Right;

public class TaskBuilderTest {

	private TaskBuilder taskBuilder;
	private Position position;

	@Before
	public void setUp() throws Exception {
		this.taskBuilder = new TaskBuilder();
		this.position = new Position(0, 0, Direction.NORTH);
	}

	@Test
	public void testLeft() throws Exception {
		ICommand command = taskBuilder.apply("LEFT");
		assertTrue(command instanceof Left);
	}

	@Test
	public void testMove() throws Exception {
		ICommand command = taskBuilder.apply("MOVE");
		assertTrue(command instanceof Move);
	}

	@Test
	public void testPlace() throws Exception {
		ICommand command = taskBuilder.apply("PLACE 0,0,NORTH");
		assertTrue(command instanceof Place);
	}

	@Test
	public void testReport() throws Exception {
		ICommand command = taskBuilder.apply("REPORT");
		assertTrue(command instanceof Report);
	}

	@Test
	public void testRight() throws Exception {
		ICommand command = taskBuilder.apply("RIGHT");
		assertTrue(command instanceof Right);
	}

	@Test
	public void testValidPlaceA() throws Exception {
		ICommand command = taskBuilder.apply("PLACE 0,0,NORTH");

		assertEquals(new Position(0, 0, Direction.NORTH).toString(), command.execute(this.position).toString());
	}

	@Test
	public void testValidPlaceB() throws Exception {
		ICommand command = taskBuilder.apply("PLACE 2,3,SOUTH");
		assertEquals(new Position(2, 3, Direction.SOUTH).toString(), command.execute(this.position).toString());
	}

	@Test
	public void testValidPlaceC() throws Exception {
		ICommand command = taskBuilder.apply("PLACE 4,2,EAST");
		boolean position = new Position(2, 4, Direction.WEST).toString()
				.equalsIgnoreCase(command.execute(this.position).toString());
		assertTrue("Position of robot should be different than position value.", !position);
	}

	@Test
	public void testValidPlaceD() throws Exception {
		ICommand command = taskBuilder.apply("PLACE 4,2,EAST");
		ICommand command2 = taskBuilder.apply("PLACE 2,1,NORTH");
		Position position = (Position) command.execute(this.position);
		Position newPosition = (Position) command2.execute(position);
		assertEquals("Robot will be placed at new Position.", new Position(2, 1, Direction.NORTH).toString(),
				newPosition.toString());
	}

	@Test
	public void testInvalidPosition() throws Exception {
		ICommand command = taskBuilder.apply("PLACE4,2,EAST");
		assertEquals(this.position.toString(), command.execute(this.position).toString());
	}

	@Test
	public void testValidPositionWithSpaces() throws Exception {
		ICommand command = taskBuilder.apply("PLACE 4, 2, east");
		assertEquals((new Position(4, 2, Direction.EAST)).toString(), command.execute(this.position).toString());
	}

	@Test
	public void testInvalidPosition2() throws Exception {
		ICommand command = taskBuilder.apply("PLACE 4,2,WRONG-DIRECTION");
		assertEquals(this.position.toString(), command.execute(this.position).toString());
	}

	// @Test
	// public void testParseDirection() throws Exception {
	// Direction val = this.taskBuilder.parseDirection("NORTH");
	// assertEquals("NORTH", val.name());
	// }

}
