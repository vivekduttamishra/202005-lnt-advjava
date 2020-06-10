package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages = {"in.conceptarchitect"})

public class MoviesConfig {

		String path="src/moviedb.json";
	
	
	   @Bean 
       public MovieRepository moviesRepository() {
    	   
    	   return MoviesJsonRepository.load(path);
    	   
       }
       
     
}




















