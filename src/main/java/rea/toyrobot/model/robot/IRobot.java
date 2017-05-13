package rea.toyrobot.model.robot;

import rea.toyrobot.model.status.Status;
import rea.toyrobot.tasks.ICommand;

public interface IRobot {

	Status getStatus();

	<R> void doTask(ICommand<R> command);
}
