package dummy.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieRepository;


@Repository  // @Component
public class DummyMovieRepository implements MovieRepository {
	
	public  DummyMovieRepository() {
		// TODO Auto-generated constructor stub
		System.out.println("Dummy Movie Repository created..."+hashCode());
	}

	@Override
	public String add(Movie entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Movie> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Movie entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
