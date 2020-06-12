package moviebootservice.in.conceptarchitect.moviebootservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.MovieValidator;
import in.conceptarchitect.movies.repository.json.MovieJsonRepository;
import in.conceptarchitect.movies.simple.SimpleMovieManager;
import in.conceptarchitect.movies.simple.SimpleMovieValidator;

@SpringBootApplication
@ComponentScan(basePackages = {"in.conceptarchitect"} )
public class MovieBootServiceApplication {
	
//	@Bean 
//	public MovieValidator validator() {
//		return new SimpleMovieValidator();
//	}
	
	@Bean
	public  MovieRepository repository() {
		String path="C:/MyWorks/Corporate/202005-lnt-javadesktop/movies-new.json";
		return new MovieJsonRepository(path);
	}
	
//	@Bean MovieManager manager(MovieRepository repository, MovieValidator validator) {
//		SimpleMovieManager manager=new SimpleMovieManager();
//		manager.setRepository(repository);
//		manager.setValidator(validator);
//		
//		return manager;
//	}

	public static void main(String[] args) {
		SpringApplication.run(MovieBootServiceApplication.class, args);
	}

}
