package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.MovieValidator;
import in.conceptarchitect.movies.jsonrepository.MoviesJsonRepository;
import in.conceptarchitect.movies.simple.SimpleMovieManager;
import in.conceptarchitect.movies.simple.SimpleMovieValidator;


@Configuration  //--> similar to <beans></beans>
public class MoviesConfig1 {

		String path="src/moviedb.json";
	
	
	   @Bean   //—> similar to </bean>  method name acts as bean name	
       public MovieRepository movieRepository() {
    	   
    	   return MoviesJsonRepository.load(path);
    	   
       }
       
       
	   @Bean
	   public MovieValidator myValidator() {
		   
		   return new SimpleMovieValidator();
	   }
	   
	   
	   @Bean
	   public MovieManager movieManager() {
		   
		   SimpleMovieManager manager=new SimpleMovieManager(movieRepository());
		   
		   manager.setValidator(myValidator());
		   
		   return manager;
	   }

}




















