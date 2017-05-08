package task;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import rea.toyrobot.model.position.Coordinate;
import rea.toyrobot.model.position.Direction;
import rea.toyrobot.model.position.Position;
import rea.toyrobot.tasks.ICommand;
import rea.toyrobot.tasks.Left;
import rea.toyrobot.tasks.Move;
import rea.toyrobot.tasks.Place;
import rea.toyrobot.tasks.Report;
import rea.toyrobot.tasks.Right;

public class TaskTest {

	private Position position;
	private Position placePosition;
	private ICommand<Position> left;
	private ICommand<Position> move;
	private ICommand<Position> place;
	private ICommand<Position> report;
	private ICommand<Position> right;

	@Before
	public void setUp() {
		this.position = new Position(new Coordinate(1, 0), Direction.NORTH);
		this.placePosition = new Position(new Coordinate(0, 0), Direction.EAST);
		this.left = new Left();
		this.move = new Move();
		this.place = new Place(this.placePosition);
		this.report = new Report();
		this.right = new Right();
	}

	@Test
	public void testLeft() {
		assertEquals(new Position(1, 0, Direction.WEST).toString(), this.left.execute(this.position).toString());
	}

	@Test
	public void testMove() {
		assertEquals(new Position(1, 1, Direction.NORTH).toString(), this.move.execute(this.position).toString());
	}

	@Test
	public void testPlace() {
		assertEquals(this.placePosition.toString(), this.place.execute(this.placePosition).toString());
	}

	@Test
	public void testReport() {
		assertEquals(new Position(1, 0, Direction.NORTH).toString(), this.report.execute(this.position).toString());
	}

	@Test
	public void testRight() {
		assertEquals(new Position(1, 0, Direction.EAST).toString(), this.right.execute(this.position).toString());
	}

}
