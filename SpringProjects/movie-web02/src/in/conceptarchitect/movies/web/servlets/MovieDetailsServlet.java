package in.conceptarchitect.movies.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieInfo;


public class MovieDetailsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

		PrintWriter writer= resp.getWriter();

		int index=req.getRequestURI().lastIndexOf("/");
		String id=req.getRequestURI().substring(index+1);
		
		//MovieManager manager=null; //how do you get movie manager?
		//Movie movie=manager.getMovieById(id); 
		
		//MovieInfo movie=new MovieInfo();
		Movie movie=new Movie();
		
		movie.setImdbID(id);
		movie.setTitle("The Accursed God");
		movie.setDescription("Based on the Epic fiction The Accursed God");
		movie.setImdbRating(9);

		
		
		
		writer.printf("<h1>About  %s</h1>\n",movie.getTitle());
		writer.printf("<p>%s</p>", movie.getDescription());

		writer.flush(); //send the output to the client
		
	}

}
