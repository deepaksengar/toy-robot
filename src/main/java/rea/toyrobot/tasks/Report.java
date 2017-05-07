package rea.toyrobot.tasks;

import rea.toyrobot.model.position.Position;

public class Report implements ICommand<Position> {

	public Position execute(Position position) {
		if (position == null) {
			System.out.println("Robot is not Placed on Surface.");
		} else {
			System.out.println(position);
		}

		return position;
	}

}
