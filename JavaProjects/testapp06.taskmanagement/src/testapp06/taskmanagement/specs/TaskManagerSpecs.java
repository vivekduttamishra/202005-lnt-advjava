package testapp06.taskmanagement.specs;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.IndexedList;
import testapp06.taskmanagement.Task;
import testapp06.taskmanagement.TaskDataSource;
import testapp06.taskmanagement.TaskManager;
import testapp06.taskmanagement.TaskPriority;
import testapp06.taskmanagement.TaskStatus;

public class TaskManagerSpecs {
	
	

	TaskManager manager=new TaskManager();
	@Before
	public void setUp() throws Exception {
		new TaskDataSource().fetchTasks(manager);
	}

	@Test
	public void getAllGetsAllAvailableTask() {
		int count=manager.getAllTask().size();
		
		assertEquals(11, count);
	}
	
	@Test
	public void getsTaskWithValidId() {
		int id=2;
		Task task= manager.getTaskById(id);
		
		assertEquals(id, task.getId());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getsTaskWithInvalidIdThrowsNoSuchElementException() {
		int id=200;
		Task task= manager.getTaskById(id);
		
	}
	
	@Test
	public void searchCanReturnAListOfPendingTasks() {
		TaskStatus status=TaskStatus.pending;
		IndexedList<Task> result= manager.search(); //you need to decide what paramter you will pass
		
		for(Task task: result) {
			assertEquals(status, task.getStatus());
		}
		
	}
	
	@Test
	public void searchCanReturnAListOfHighPriorityTasks() {
		TaskPriority priority=TaskPriority.High;
		IndexedList<Task> result= manager.search(); //you need to decide what paramter you will pass
		
		for(Task task: result) {
			assertEquals(priority, task.getPriority());
		}
		
	}
	
	@Test
	public void searchTaskWithDatabaseInTheirTitle() {
		String partTitle= "database"; //case insensetive search part match
		
		IndexedList<Task> result= manager.search(); //you need to decide what paramter you will pass
		
		assertEquals(4, result.size());
		

		for(Task task: result) {
			assertTrue(task.getTitle().toLowerCase().contains(partTitle.toLowerCase()));
		}
		
	}
	
	
	@Test
	public void searchTaskWithAtExactlyOneNote() {
		int noteCount=1;
		
		IndexedList<Task> result= manager.search(); //you need to decide what paramter you will pass
		
		

		for(Task task: result) {
			assertEquals(noteCount, task.getNotes().size());
		}
		
	}
}
