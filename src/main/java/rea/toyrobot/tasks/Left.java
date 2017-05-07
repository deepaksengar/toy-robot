package rea.toyrobot.tasks;

import rea.toyrobot.model.position.Position;

public class Left implements ICommand<Position> {

	@Override
	public Position execute(Position position) {
		return new Position(position.getCoordinate(), position.getDirection().left());
	}
}
