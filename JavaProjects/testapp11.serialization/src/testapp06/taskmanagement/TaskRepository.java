package testapp06.taskmanagement;

import java.util.Collection;
import java.util.function.Predicate;

public interface TaskRepository {

	int add(Task task);
	
	Collection<Task> getAllTasks();
	
	Task getById(int id);
	
	Collection<Task> search(Predicate<Task> task);
	
	public void save();
	
	
	
}
