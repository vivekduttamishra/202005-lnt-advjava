package testapp06.taskmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Task implements Serializable{

	
	int id;
	String title;
	ArrayList<String> notes=new ArrayList<String>();
	TaskPriority priority;
	TaskStatus status;
	public Task(  String title, TaskPriority priority, TaskStatus status, String ...notes) {
		super();
		this.id = 0;
		this.title = title;
		this.priority = priority;
		this.status = status;
		
		for(String note:notes)
			this.notes.add(note);
	}
	public Task(String title) {
		this(title,TaskPriority.Medium, TaskStatus.pending);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public ArrayList<String> getNotes() {
		return notes;
	}
	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	public TaskPriority getPriority() {
		return priority;
	}
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", priority=" + priority + ", status=" + status + "]";
	}
	
	
	
	
}
