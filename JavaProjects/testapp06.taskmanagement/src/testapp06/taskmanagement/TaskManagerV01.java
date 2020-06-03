package testapp06.taskmanagement;

import java.util.NoSuchElementException;

import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;

public class TaskManagerV01 {

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
		
		for(Task task: tasks) {
			if(task.getId()==id)
				return task;
		}
			
		throw new NoSuchElementException("Invalid Id:"+id);
	}

	public IndexedList<Task> search(TaskStatus status) {
		// TODO Auto-generated method stub
		LinkedList<Task> result=new LinkedList<Task>();
		for(Task task : tasks) {
			if(task.getStatus()==status)
				result.add(task);
		}
		return result;
	}

	public IndexedList<Task> search(TaskPriority priority) {
		// TODO Auto-generated method stub
		LinkedList<Task> result=new LinkedList<Task>();
		for(Task task : tasks) {
			if(task.getPriority()==priority)
				result.add(task);
		}
		return result;
	}

	public IndexedList<Task> search(String partTitle) {
		
		// TODO Auto-generated method stub
		partTitle=partTitle.toLowerCase();
		LinkedList<Task> result=new LinkedList<Task>();
		for(Task task : tasks) {
			if(task.getTitle().toLowerCase().contains(partTitle))
				result.add(task);
		}
		return result;
	}

	public IndexedList<Task> search(int noteCount) {
		// TODO Auto-generated method stub
		LinkedList<Task> result=new LinkedList<Task>();
		for(Task task : tasks) {
			if(task.getNotes().size()==noteCount)
				result.add(task);
		}
		return result;
		
	}
	
	
	
}
