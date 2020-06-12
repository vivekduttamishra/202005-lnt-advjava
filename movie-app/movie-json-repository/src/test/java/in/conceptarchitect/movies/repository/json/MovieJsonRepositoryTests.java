package in.conceptarchitect.movies.repository.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieRepository;

public class MovieJsonRepositoryTests {

	String path="c:/temp/movies-test";
	
	String targetPath;
	MovieJsonRepository repository;
	
	@Before
	public void setUp() throws Exception {
		String src=path+".json";
		String trgt=path+"-test.json";
		duplicateFile(src,trgt);
	
		repository=new MovieJsonRepository(trgt);
		targetPath=trgt;
	}

	private void duplicateFile(String src, String trgt) {
		// TODO Auto-generated method stub
		try {
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream(trgt);
		int ch;
		while((ch=fis.read())!=-1) {
			fos.write(ch);
		}
		fis.close();
		fos.close();
		}
		catch(Exception ex) {
			throw new RuntimeException (ex);
		}
		
	}

	@Test
	public void canLoadRepository() {
		Collection<Movie> movies=repository.getAll();
		for(Movie movie:movies)
			System.out.println(movie);
		assertEquals(5, movies.size());
	}
	@Test
	public void canAddToRepository() {
		Movie movie=new Movie();
		movie.setImdbID("tt0000001");
		movie.setImdbRating(8);
		movie.setTitle("Test Movie");
		movie.setDescription("Test Movie Description");
		movie.setYear("2001");
		movie.setPoster("c:\testmovie.jpg");
		movie.setType("movie");
		
		repository.add(movie);
		repository.save();
		
		MovieRepository newRepo=new MovieJsonRepository(targetPath);
		Collection<Movie> movies=newRepo.getAll();
		
		assertEquals(6, movies.size());
		
		Movie result=newRepo.getById(movie.getImdbID());
		
		assertNotNull(result);
		assertEquals(result.getDescription(), movie.getDescription());
		
		
	}

}
