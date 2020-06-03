package testapp06.taskmanagement;

import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;

public class TaskManager {

	LinkedList<Task> tasks=new LinkedList<Task>();
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public LinkedList<Task> getAllTask(){
		return tasks;
	}

	public IndexedList<Task> search() {
		// TODO Auto-generated method stub
		return null;
	}

	public Task getTaskById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
