package testapp06.taskmanagement;

import java.util.Collection;

public interface TaskRepository {

	int add(Task task);
	
	Collection<Task> getAllTasks();
	
	int getById(int id);
	
	Collection<Task> search();
	
}
