package testapp06.taskmanagement;

import java.util.NoSuchElementException;

import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;
import in.conceptarchitect.collections.Matcher;

public class TaskManager {

	LinkedList<Task> tasks=new LinkedList<Task>();
	int lastId=0;
	
	public void addTask(Task task) {
		lastId++;
		task.setId(lastId);
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
		
		IndexedList<Task> result=tasks.search(t->t.getId()==id);
		if(result.size()>0)
			return result.get(0);
		else
			throw new NoSuchElementException("Invalid Id:"+id);
	}

	public IndexedList<Task> search(TaskStatus status) {
		
		return tasks.search(new TaskStatusMatcher(status));
		
	}

	public IndexedList<Task> search(TaskPriority priority) {
		// TODO Auto-generated method stub
		return tasks.search(new Matcher<Task>() {
			
			@Override
			public boolean isMatch(Task item) {
				// TODO Auto-generated method stub
				return item.getPriority()==priority;
			}
		});
	}

	public IndexedList<Task> search(String partTitle) {
		
		final String title=partTitle.toLowerCase();
		
		return tasks.search(task -> task.getTitle().toLowerCase().contains(title) );
	}

	public IndexedList<Task> search(int noteCount) {

		return tasks.search(task-> task.getNotes().size()==noteCount);
		
	}
	
	
	
}
