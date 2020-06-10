package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.MovieValidator;
import in.conceptarchitect.movies.jsonrepository.MoviesJsonRepository;
import in.conceptarchitect.movies.simple.SimpleMovieManager;
import in.conceptarchitect.movies.simple.SimpleMovieValidator;


@Configuration  //--> similar to <beans></beans>
public class MoviesConfig2 {

		String path="src/moviedb.json";
	
	
	   @Bean   //—> similar to </bean>  method name acts as bean name	
       public MovieRepository movieRepository() {
    	   
    	   return MoviesJsonRepository.load(path);
    	   
       }
       
       
	   @Bean
	   @Scope("prototype")
	   public MovieValidator myValidator() {
		   
		   return new SimpleMovieValidator();
	   }
	   
	   
	   @Bean
	   @Lazy
	   public MovieManager movieManager(MovieValidator validator, MovieRepository repository) {
		   
		   SimpleMovieManager manager=new SimpleMovieManager(repository);
		   
		   manager.setValidator(validator);
		   
		   return manager;
	   }

}




















