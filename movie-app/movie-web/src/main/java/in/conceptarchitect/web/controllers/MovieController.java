package in.conceptarchitect.web.controllers;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieManager;

@Controller  //—> alias for @Component
public class MovieController {
	
	
	@Autowired
	MovieManager manager;
	

	@RequestMapping("/movies")	
	public String index(HashMap<String,Object> model) {
		
		
		//tell what is the data model
		model.put("movies", 
					manager
						.getAllMovies()
						.stream()
						.map(this::updatePoster)
						.collect(Collectors.toList())
					
				);
		
		//tell where to show it
		return "movie-list";  //WEB-INF/views/moive-list.jsp --> request.getRequestDispatcher(...).forward()
	}
	
	@RequestMapping("/movie/{imdbId}")
	public String getMovieById(@PathVariable("imdbId")String imdbId,HashMap<String,Object> model) {
		
		Movie movie= manager.getMovieById(imdbId);
		
		model.put("movie", updatePoster(movie));
		
		return "movie-details";
	}

	private Movie updatePoster(Movie movie) {
		String poster=movie.getPoster();
		if(!poster.startsWith("http"))
			movie.setPoster("/movie-web/resources"+poster);
		return movie;
	}
	
	@RequestMapping(value="/movie/add",method=RequestMethod.GET)
	public String addMovie(HashMap<String,Object>model)
	{
		model.put("movie", new Movie());
		return "movie-add";
	}
	
	@RequestMapping(value="/movie/add",method=RequestMethod.POST)
	public String saveMovie(@ModelAttribute("movie")Movie movie)
	{
		manager.addMovie(movie);
		return "redirect:/movies";
	}
	
	
	
}
