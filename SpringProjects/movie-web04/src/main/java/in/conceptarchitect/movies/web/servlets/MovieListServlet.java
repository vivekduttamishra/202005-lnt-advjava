package in.conceptarchitect.movies.web.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.movies.Movie;

public class MovieListServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		Collection<Movie> movies=MovieManagerFactory.instance().getAllMovies();
		
		req.setAttribute("movies", movies);
		req.getRequestDispatcher("/WEB-INF/views/movie-list.jsp")
			.forward(req,resp);
		
		
	}

}
