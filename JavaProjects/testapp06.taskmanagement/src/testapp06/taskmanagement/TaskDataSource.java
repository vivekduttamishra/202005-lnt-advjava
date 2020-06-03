package testapp06.taskmanagement;

public class TaskDataSource {
	
	public void fetchTasks(TaskManager manager) {
		
		manager.addTask(new Task("Learn Java 8",TaskPriority.High, TaskStatus.started, "Interface Defaults","Static Interface Methods"));
		manager.addTask(new Task("Streams Programming",TaskPriority.Medium, TaskStatus.pending));
		manager.addTask(new Task("Database using JDBC",TaskPriority.High, TaskStatus.pending,"Use MySql and example"));
		manager.addTask(new Task("Database using hibernate",TaskPriority.High, TaskStatus.pending));
		manager.addTask(new Task("Java Persistence",TaskPriority.Low, TaskStatus.started));
		manager.addTask(new Task("Unit Testing",TaskPriority.High, TaskStatus.completed));
		manager.addTask(new Task("TDD",TaskPriority.High, TaskStatus.started, "Red Green Refactor","JUnit 4 design","exception handling"));
		manager.addTask(new Task("Servlet Web Application",TaskPriority.Medium, TaskStatus.pending));
		manager.addTask(new Task("Spring Web Application",TaskPriority.High, TaskStatus.started));
		manager.addTask(new Task("Database using JPA",TaskPriority.High, TaskStatus.started, "JPA should use hiberanate provider"));
		manager.addTask(new Task("Database using spring hibernate",TaskPriority.High, TaskStatus.completed, "annotation driven","spring configuation","spring code"));
		
	}

}
