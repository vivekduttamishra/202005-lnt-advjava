package in.conceptarchitect.movies;

import java.util.Collection;

import in.conceptarchitect.practices.ValidationMessage;

public interface MovieManager {
	
	ValidationMessage addMovie(Movie movie);
	
	Movie getMovieById(String imdbId);
	
	Collection<Movie> getAllMovies();
	
	Collection<Movie> search(String text);
	
	ValidationMessage update(Movie movie);
	
	void delete(String imdbId);

}
