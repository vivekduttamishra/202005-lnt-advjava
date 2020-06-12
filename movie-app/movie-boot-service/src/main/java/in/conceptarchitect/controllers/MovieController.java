package in.conceptarchitect.controllers;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieManager;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired MovieManager movieManager;
	
	@RequestMapping
	public Collection<Movie> getAllMovies(){
		return movieManager.getAllMovies();
	}
	
	@RequestMapping("{id}")
	public Movie getMovieById(@PathVariable("id")String id) {
		System.out.println("searching movie with id "+id);
		return movieManager.getMovieById(id);
	}
	
}
