package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import in.conceptarchitect.practices.jdbc.JdbcManager;


@Configuration  //--> similar to <beans></beans>
@ComponentScan(basePackages = {"in.conceptarchitect"})
@EnableAspectJAutoProxy
public class MoviesConfig {

		String path="src/moviedb.json";
	
	
//	   @Bean 
//       public MovieRepository moviesRepository() {
//    	   
//    	   //return MoviesJsonRepository.load(path);
//		   
//		   return new MoviesJdbcRepository("jdbc:mysql://localhost/lnt_movies", "root", "tr@1n1nG");
//		   
//    	   
//       }
		
		@Bean
		JdbcManager jdbcManager() {
			return new JdbcManager("jdbc:mysql://localhost/lnt_movies", "root", "root");
		}
       
		
     
}




















