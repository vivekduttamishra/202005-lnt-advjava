package in.conceptarchitect.movies.web.servlets;

import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.jdbcrepository.MoviesJdbcRepository;
import in.conceptarchitect.movies.simple.SimpleMovieManager;
import in.conceptarchitect.practices.jdbc.JdbcManager;

public class MovieManagerFactory {
	static MovieManager manager;
	
	public static MovieManager instance() {
		if(manager==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e.getMessage(),e);
			}
			
			JdbcManager jdbc= new JdbcManager("jdbc:mysql://localhost/lnt_movies", "root", "root");
			MovieRepository rep=new MoviesJdbcRepository(jdbc);
			manager=new SimpleMovieManager(rep);

		}
		
		return manager;
	}
	
}
