package in.conceptarchitect.movies.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieManager;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.movies.jdbcrepository.MoviesJdbcRepository;
import in.conceptarchitect.movies.simple.SimpleMovieManager;
import in.conceptarchitect.practices.jdbc.JdbcManager;


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
		
		
		
		Movie movie=MovieManagerFactory.instance().getMovieById(id);

		String viewName="";
		
		if(movie!=null) {
			
			req.setAttribute("movie", movie);
			viewName="movie-details";
		}
		else {
			resp.setStatus(404);
			req.setAttribute("error", "Not Found");
			req.setAttribute("id", id);
			viewName="error";
		} 
		
		String viewPath="/WEB-INF/views/"+viewName+".jsp";
		
		req.getRequestDispatcher(viewPath)
			.forward(req,resp);
		
		
	}

}
