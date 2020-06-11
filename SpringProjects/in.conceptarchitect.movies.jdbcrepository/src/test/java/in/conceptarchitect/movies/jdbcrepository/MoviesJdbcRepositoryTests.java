package in.conceptarchitect.movies.jdbcrepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.practices.jdbc.JdbcManager;

public class MoviesJdbcRepositoryTests {

	MoviesJdbcRepository repository;
	JdbcManager jdbc;
	
	@Before
	public void setUp() throws Exception {
		jdbc=new JdbcManager("jdbc:mysql://localhost:3306/lnt_movies","root","tr@1n1nG");
		
		repository=new MoviesJdbcRepository(jdbc);
	}

	
	@Test
	public void getAllReturnsAListOf0BooksFromEmptyDatabase() {

		Collection<?> result= repository.getAll();
		
		assertEquals(6, result.size());
		
		
	}
	
	@Test
	public void getByIdWithValidIdReturnsValidMovie() {

		Movie movie= repository.getById("tt1234");
		System.out.println(movie);
		assertNotNull(movie);
		
		
	}
	
	@Test
	public void getByIdWithInValidIdReturnsNull() {

		Movie movie= repository.getById("invalid_id");
		System.out.println(movie);
		assertNull(movie);
		
		
	}

}
