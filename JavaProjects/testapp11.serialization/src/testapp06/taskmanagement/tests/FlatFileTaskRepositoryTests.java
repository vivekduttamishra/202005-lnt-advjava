package testapp06.taskmanagement.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import testapp06.taskmanagement.FlatFileTaskRepository;
import testapp06.taskmanagement.Task;
import testapp06.taskmanagement.TaskPriority;
import testapp06.taskmanagement.TaskStatus;

public class FlatFileTaskRepositoryTests {

	String path="./src/test-tasks.db";
	FlatFileTaskRepository repository;
	File file=new File(path);
	
	@Before
	
	public void setUp() throws Exception {
		
		if(file.exists())
			file.delete(); //delete test file if it exists
		
		repository=FlatFileTaskRepository.load(path);
		
	}

	@Test
	public void canLoadNonExisitingRepository() {
		assertNotNull(repository);
	}
	
	@Test
	public void canAddTaskToAnReposiotory() {
		int id= repository.add(new Task("Simple Task"));
		
		assertEquals(1,id);
	}
	
	@Test
	public void canSaveAnEmptyRepository() {
		repository.save();
		
		assertTrue(file.exists());
	}
	
	@Test
	public void canSaveNonEmptyRepository() {
		repository.add(new Task("SampleTask"));
		
		repository.save();
		
		assertTrue(file.exists());
	}
	
	@Test
	public void canSaveAndLoadRepository() {
		repository.add(new Task("Save Task"));
		repository.save();
		
		FlatFileTaskRepository rep2=FlatFileTaskRepository.load(path);
		assertEquals(1, rep2.getAllTasks().size());
		assertEquals("Save Task", rep2.getById(1).getTitle());
	}
	
	@Test
	public void notesCanBeSavedAndLoadedWithTask() {
		Task task=new Task("Task with notes", TaskPriority.High	, TaskStatus.completed	, "Notes 1","Notes 2","Notes 3");
		
		repository.add(task);
		repository.save();
		
		FlatFileTaskRepository rep2=FlatFileTaskRepository.load(path);
		Task taskRep2=rep2.getById(task.getId());
		
		assertEquals(3, taskRep2.getNotes().size());
		
		
		
	}
	

}
