package testapp06.taskmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;


public class TaskManager {

	TaskRepository repository;
	
	
	
	public TaskManager(TaskRepository repository) {
		super();
		this.repository = repository;
	}
	
	

	public int addTask(Task task) {
		int id= repository.add(task);
		repository.save();
		return id;
		
	}
	
	public Collection<Task> getAllTask(){
		return repository.getAllTasks();
	}

	public Collection<Task> search() {
		// TODO Auto-generated method stub
		return new ArrayList<Task>();
	}

	public Task getTaskById(int id) {
		// TODO Auto-generated method stub
		
		Collection<Task> result=repository.search(t->t.getId()==id);
		
		for(Task task:result)
			return task;
		
		throw new NoSuchElementException("Invalid Id:"+id);
	}

	public Collection<Task> search(TaskStatus status) {
		
		return repository.search(task->task.status==status);
		
	}

	public Collection<Task> search(TaskPriority priority) {
		// TODO Auto-generated method stub
		return repository.search(task->task.priority==priority);
		
	}

	public Collection<Task> search(String partTitle) {
		
		final String title=partTitle.toLowerCase();
		
		return repository.search(task -> task.getTitle().toLowerCase().contains(title) );
	}

	public Collection<Task> search(int noteCount) {

		return repository.search(task-> task.getNotes().size()==noteCount);
		
	}
	
	
	
}
