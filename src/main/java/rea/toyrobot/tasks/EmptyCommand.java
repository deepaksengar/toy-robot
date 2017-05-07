package rea.toyrobot.tasks;

public class EmptyCommand<R> implements ICommand<R> {

	@Override
	public R execute(R r) {
		return r;
	}
}
