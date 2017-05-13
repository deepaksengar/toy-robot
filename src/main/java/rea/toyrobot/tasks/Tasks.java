package rea.toyrobot.tasks;

public enum Tasks {
	PLACE {
		public ICommand<?> getCommand(String task) {
			return new Place(task);
		};
	},

	MOVE {
		public ICommand<?> getCommand(String task) {
			return new Move();
		};
	},
	LEFT {
		public ICommand<?> getCommand(String task) {
			return new Left();
		};
	},
	RIGHT {
		public ICommand<?> getCommand(String task) {
			return new Right();
		};
	},
	REPORT {
		public ICommand<?> getCommand(String task) {
			return new Report();
		};
	};

	public abstract ICommand<?> getCommand(String task);

}
