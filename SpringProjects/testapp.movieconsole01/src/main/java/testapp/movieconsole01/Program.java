package testapp.movieconsole01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.MoviesConfig;
import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.MovieValidator;
//import in.conceptarchitect.movies.jsonrepository.MoviesJsonRepository;
import in.conceptarchitect.movies.simple.SimpleMovieManager;
import in.conceptarchitect.movies.simple.SimpleMovieValidator;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Program Starts. Calling getMovieManager...");

		MovieManager manager = getMovieManager();
		System.out.println("manager =>"+manager.getClass());

		
		
		int choice=0;
		do {
			choice=Input.readInt("1. add movie 2. list movies 3. search by id 0. exit?");
			
			switch(choice) {
			case 1: addMovie(manager); break;
			case 2: getAllMovies(manager);break;
			case 3: getMovieById(manager);break;
			case 0: break;
			default:System.out.println("invalid choice. retry"); break;
			}
			System.out.println("\n-—--\n\n");
		}while(choice!=0);
		
				
	}

	private static void getMovieById(MovieManager manager) {
		// TODO Auto-generated method stub
		String str=Input.read("imdb id?");
		if(str=="")
			return ;
		Movie movie=manager.getMovieById(str);
		System.out.println(movie);
		
		
	}

	public static MovieManager getMovieManager() {

		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/movieconfig.xml");
		
		ApplicationContext context=new AnnotationConfigApplicationContext(MoviesConfig.class);
		
		return context.getBean(MovieManager.class);
	}

	public static MovieManager getMovieManager2() {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/movieconfig.xml");

		// Get me the movie manager
		SimpleMovieManager manager = context.getBean(SimpleMovieManager.class);

		System.out.println("validator is " + manager.getValidator());
		System.out.println("repository is " + manager.getRepository());

		return manager;
	}

	// MOST IMPORTANT FUNCTION. THIS IS DEPENDENCY INJECTION
	private static MovieManager getMovieManagerScopeTests() {
		// TODO Auto-generated method stub
		System.out.println("creating the context...");

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/movieconfig.xml");

		System.out.println("context is ready...");

		System.out.println("getting the movie manager...");

		MovieManager manager1 = (MovieManager) context.getBean("singleMovieManager"); // get an object with the given
																						// name
		System.out.println("manager1 " + manager1.hashCode());

		MovieManager manager2 = (MovieManager) context.getBean("singleMovieManager"); // get an object with the given
																						// name
		System.out.println("manager2 " + manager2.hashCode());

		MovieManager manager3 = (MovieManager) context.getBean("prototypeMovieManager"); // get an object with the given
																							// name
		System.out.println("manager3 " + manager3.hashCode());

		MovieManager manager4 = (MovieManager) context.getBean("prototypeMovieManager"); // get an object with the given
																							// name
		System.out.println("manager4 " + manager4.hashCode());

		return manager1;
	}

	// MOST IMPORTANT FUNCTION. THIS IS DEPENDENCY INJECTION
	private static MovieManager getMovieManager0() {
		// TODO Auto-generated method stub

//		String path = "src/moviedb.json";
//		MovieRepository rep = MoviesJsonRepository.load(path);
//
//		MovieValidator validator = new SimpleMovieValidator();
//
//		SimpleMovieManager manager = new SimpleMovieManager();
//
//		// define the dependnecies
//
//		manager.setValidator(validator);
//
//		manager.setRepository(rep);
//
		MovieManager manager=null;
		return manager;
	}

	private static void addMovie(MovieManager manager) {
		// TODO Auto-generated method stub
		String id = Input.read("Imdb Id?");
		if (id.contentEquals(""))
			return;

		Movie movie = new Movie();
		movie.setImdbID(id);
		movie.setTitle(Input.read("title?"));
		movie.setDescription(Input.read("description?"));
		movie.setImdbRating(Input.readInt("imdb rating?"));

		manager.addMovie(movie);

	}

	private static void getAllMovies(MovieManager manager) {
		// TODO Auto-generated method stub

		for (Movie movie : manager.getAllMovies()) {
			System.out.printf("%s\t%f\t%s\n\t%s\n", movie.getImdbID(), movie.getImdbRating(), movie.getTitle(),
					movie.getDescription());
		}

	}

	private static void addDummyMovies(MovieManager manager) {
		// TODO Auto-generated method stub
		if (!Input.read("Do you want to add dummy movies?").contentEquals("y"))
			return;

		manager.addMovie(createMovie("tt1230", "Harry Potter and the Order of Phonex", 6,
				"The Fifth part of harry potter saga"));
		manager.addMovie(createMovie("tt1231", "Harry Potter and the chamber of secrets", 8.2,
				"The Second part of harry potter saga"));
		manager.addMovie(createMovie("tt1232", "X2", 7.5, "Part 2 of XMen series"));
		manager.addMovie(createMovie("tt1233", "XMen", 7.2, "First Part of Xmen series"));

	}

	static Movie createMovie(String imdbId, String title, double rating, String description) {
		Movie movie = new Movie();
		movie.setImdbID(imdbId);
		movie.setTitle(title);
		movie.setImdbRating(rating);
		movie.setDescription(description);
		return movie;
	}

}
