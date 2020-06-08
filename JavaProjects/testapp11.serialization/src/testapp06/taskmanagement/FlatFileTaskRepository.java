package testapp06.taskmanagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlatFileTaskRepository implements TaskRepository , Serializable{
	
	
	HashMap<Integer, Task> tasks=new HashMap<Integer, Task>();
	int lastId=0;
	String path;
	

	@Override
	public int add(Task task) {
		// TODO Auto-generated method stub
		task.setId(++lastId);
		tasks.put(lastId, task);
		return lastId;
	}

	@Override
	public Collection<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return tasks.values();
	}

	@Override
	public Task getById(int id) {
		// TODO Auto-generated method stub
		if(tasks.containsKey(id))
			return tasks.get(id);
		else
			return null;
	}

	@Override
	public Collection<Task> search(Predicate<Task> condition) {
		// TODO Auto-generated method stub
		return tasks.values().stream().filter(condition).collect(Collectors.toList());
	}
	
	
	

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
		FileOutputStream file=null;
		ObjectOutputStream out=null;
		
		try {
			file=new FileOutputStream(path);   //where  data will saved
			out=new ObjectOutputStream(file);  //what  we will save some object
			
			out.writeObject(this); //write this repository to the file
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try { out.close(); file.close(); }catch(Exception ex) {}
		}
		

	}
	
	
	
	public static FlatFileTaskRepository load(String path) {
		// TODO Auto-generated method stub
		
		FileInputStream file=null;
		ObjectInputStream in=null;
		FlatFileTaskRepository repository;
		
		try {
			file=new FileInputStream(path);   //where  data will comefrom
			in=new ObjectInputStream(file);  //what  we will load
			
			repository=(FlatFileTaskRepository) in.readObject(); //write this repository to the file
		} catch (Exception e) {
		
			repository=new FlatFileTaskRepository();
			
		}finally {
			try { in.close(); file.close(); }catch(Exception ex) {}
		}
		repository.path=path;
		return repository;
		

	}

}
