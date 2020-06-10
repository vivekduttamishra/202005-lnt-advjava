package testapp.movieconsole01;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.MovieValidator;
import in.conceptarchitect.movies.jsonrepository.MoviesJsonRepository;
import in.conceptarchitect.movies.simple.SimpleMovieManager;
import in.conceptarchitect.movies.simple.SimpleMovieValidator;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieManager manager=getMovieManager();
		
		addDummyMovies(manager);
		addMovie(manager);
		getAllMovies(manager);
		
	}
	
	
	
	private static void addMovie(MovieManager manager) {
		// TODO Auto-generated method stub
		String id=Input.read("Imdb Id?");
		if(id.contentEquals(""))
			return ;
		
		
		Movie movie=new Movie();
		movie.setImdbID(id);
		movie.setTitle(Input.read("title?"));
		movie.setDescription(Input.read("description?"));
		movie.setImdbRating(Input.readInt("imdb rating?"));
		
		
		manager.addMovie(movie);
		
	}



	//MOST IMPORTANT FUNCTION. THIS IS DEPENDENCY INJECTION
	private static MovieManager getMovieManager() {
		// TODO Auto-generated method stub
		
		String path="src/moviedb.json";
		MovieRepository rep= MoviesJsonRepository.load(path);
		
		MovieValidator validator=new SimpleMovieValidator();
		
		
		SimpleMovieManager manager=new SimpleMovieManager();
		
		//define the dependnecies
		
		manager.setValidator(validator);
		
		manager.setRepository(rep);
		
		
		
		return manager;
	}
	
	

	private static void getAllMovies(MovieManager manager) {
		// TODO Auto-generated method stub
		
		for(Movie movie : manager.getAllMovies()) {
			System.out.printf("%s\t%f\t%s\n\t%s\n", movie.getImdbID(),movie.getImdbRating(),movie.getTitle(),movie.getDescription());
		}
		
	}

	private static void addDummyMovies(MovieManager manager) {
		// TODO Auto-generated method stub
		if(!Input.read("Do you want to add dummy movies?").contentEquals("y"))
			return;
		
		manager.addMovie(createMovie("tt1231","Harry Potter and the Half blood prince",7.8,"The Sixth part of harry potter saga"));
		manager.addMovie(createMovie("tt1232","Harry Potter and the chamber of secrets",8.2,"The Second part of harry potter saga"));
		manager.addMovie(createMovie("tt1233","Avengers: The End Game",8.2,"The last part of Avengers"));
		manager.addMovie(createMovie("tt1234","XMen",7.2,"First Part of Xmen series"));
		
	
	}

	
	
	
	static Movie createMovie(String imdbId, String title,double rating, String description) {
		Movie movie =new Movie();
		movie.setImdbID(imdbId);
		movie.setTitle(title);
		movie.setImdbRating(rating);
		movie.setDescription(description);
		return movie;
	}
	

}
