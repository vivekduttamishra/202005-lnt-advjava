package testapp06.taskmanagement;

import in.conceptarchitect.collections.Matcher;

public class TaskStatusMatcher implements Matcher<Task> {

	private TaskStatus status;

	public TaskStatusMatcher(TaskStatus status) {
		// TODO Auto-generated constructor stub
		this.status=status;
	}

	@Override
	public boolean isMatch(Task item) {
		// TODO Auto-generated method stub
		return item.getStatus()==status;
	}

}
