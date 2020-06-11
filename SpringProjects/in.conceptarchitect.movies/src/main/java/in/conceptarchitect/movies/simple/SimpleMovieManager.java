package in.conceptarchitect.movies.simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.MovieValidator;
import in.conceptarchitect.practices.ValidationMessage;
import in.conceptarchitect.practices.aop.LogIt;


@Component
public class SimpleMovieManager implements MovieManager {
	
	
	
	MovieRepository repository;
	
	@Autowired
	MovieValidator validator;
	
	
	@Autowired
	public SimpleMovieManager(MovieRepository repository) {
		this.repository=repository;
		System.out.println("Simple Movie Manager Object created with hashCode"+hashCode());
		System.out.println("Repository Injected is "+repository);
	}
	
	public SimpleMovieManager(){
		System.out.println("Simple Movie Manager Object created with hashCode"+hashCode());
	}

	public MovieRepository getRepository() {
		return repository;
	}

	public void setRepository(MovieRepository repository) {
		this.repository = repository;
	}

	public ValidationMessage addMovie(Movie movie) {
		// TODO Auto-generated method stub
		if(movie==null)
			return new ValidationMessage().addError("*", "Object Can't be Null");
		ValidationMessage validation=validator.validate(movie);
		if(validation.isSuccess()) {
			repository.add(movie);
			repository.save();
			
		}
		return validation;
	}

	public Movie getMovieById(String imdbId) {
		// TODO Auto-generated method stub
		return repository.getById(imdbId);
	}

	
	@LogIt
	public Collection<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return repository.getAll();
	}

	public Collection<Movie> search(String text) {
		// TODO Auto-generated method stub
		text=text.toLowerCase();
				
		List<Movie> movies=new ArrayList<Movie> ();
		for(Movie movie : getAllMovies())
			if(		movie.getTitle().contains(text) || 
					movie.getDescription().contains("text") || 
					movie.getTag().contains(text))
				movies.add(movie);
		
		return movies;
	}

	public ValidationMessage update(Movie movie) {
		// TODO Auto-generated method stub
		if(movie==null)
			return new ValidationMessage().addError("*", "Object Can't be Null");
		Movie oldMovie=repository.getById(movie.getImdbID());
		if(oldMovie==null)
			return new ValidationMessage().addError("imdbId", "No Movie with given ImdbId");
		
		oldMovie.setTitle(movie.getTitle());
		oldMovie.setDescription(movie.getDescription());
		oldMovie.setTag(movie.getTag());
		oldMovie.setImdbRating(movie.getImdbRating());
		oldMovie.setPoster(movie.getPoster());
		oldMovie.setType(movie.getType());
		oldMovie.setYear(movie.getYear());

		repository.save();
		
		return ValidationMessage.success;
	
	}

	public void delete(String imdbId) {
		// TODO Auto-generated method stub
		repository.delete(imdbId);
		repository.save();

	}

	public MovieValidator getValidator() {
		return validator;
	}

	public void setValidator(MovieValidator validator) {
		this.validator = validator;
	}

}
