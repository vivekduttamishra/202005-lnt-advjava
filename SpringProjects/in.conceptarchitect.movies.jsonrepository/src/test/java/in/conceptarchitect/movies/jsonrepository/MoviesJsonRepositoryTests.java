package in.conceptarchitect.movies.jsonrepository;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.movies.Movie;

public class MoviesJsonRepositoryTests {
	
	String path="src/testrepository.json";
	MoviesJsonRepository repository;
	File file;

	
	String id1="tt1234";
	String title1="Harry Potter and the Half Blood Prince";
	

	String id2="tt1111";
	String title2="Avengers : End Game";
	
	@Before
	public void setUp() throws Exception {
		
		
		file=new File(path);
		if(file.exists())
			file.delete();
		
		repository=MoviesJsonRepository.load(path);
	}
	

	@Test
	public void returnsEmptyRepositoryIfPathIsNonExistant() {
		
		assumeFalse(file.exists());
		
		//test runs only if path is not a valid file
		assertNotNull(repository);
		assertEquals(0, repository.getAll().size());
	}
	
	@Test
	public void canSaveEmptyRepository() {
		repository.save();
		assertTrue(file.exists());
		
	}
	
	Movie createMovie(String imdbId, String title) {
		Movie movie =new Movie();
		movie.setImdbID(imdbId);
		movie.setTitle(title);
		return movie;
	}
	
	@Test
	public void canSaveMovies() {
		
		addDummyMovies();
		
		assertTrue(file.length()>2);
		
		
	}
	
	
	@Test
	public void canLoadMovies() {
		//Arrange
		addDummyMovies();
		
		//ACT
		MoviesJsonRepository rep2= MoviesJsonRepository.load(path);
		
		assertEquals(2, rep2.getAll().size());
		
		assertEquals(title2, rep2.getById(id2).getTitle());
		
		
	}


	private void addDummyMovies() {
		repository.add(createMovie(id1,title1));
		repository.add(createMovie(id2,title2));
		repository.save();
	}
	
	
	

}
