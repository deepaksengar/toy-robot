package rea.toyrobot.tasks;

public interface ICommand<R> {
	R execute(R r);
}
