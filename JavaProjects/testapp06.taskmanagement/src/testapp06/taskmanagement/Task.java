package testapp06.taskmanagement;

import in.conceptarchitect.collections.LinkedList;

public class Task {

	int lastId=0;
	int id;
	String title;
	LinkedList<String> notes=new LinkedList<String>();
	TaskPriority priority;
	TaskStatus status;
	public Task( String title, TaskPriority priority, TaskStatus status, String ...notes) {
		super();
		this.id = ++lastId;
		this.title = title;
		this.priority = priority;
		this.status = status;
		
		this.notes.addMany(notes);
	}
	public Task(String title) {
		this(title,TaskPriority.Medium, TaskStatus.pending);
		
	}
	public int getLastId() {
		return lastId;
	}
	public void setLastId(int lastId) {
		this.lastId = lastId;
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
	public LinkedList<String> getNotes() {
		return notes;
	}
	public void setNotes(LinkedList<String> notes) {
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
