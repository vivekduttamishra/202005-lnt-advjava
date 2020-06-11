package in.conceptarchitect.movies.jdbcrepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.practices.jdbc.JdbcManager;
import in.conceptarchitect.practices.jdbc.ObjectResultSetMapper;
import in.conceptarchitect.practices.jdbc.SqlRuntimeException;

@Repository("moviesRepository")
public class MoviesJdbcRepository implements MovieRepository {

	
	JdbcManager jdbc;
	

	@Autowired
	public MoviesJdbcRepository(JdbcManager manager) {
		super();
		this.jdbc = manager;
	}



	@Override
	public String add(Movie movie) {

		final String qry= String.format("insert into movies(imdb_id,title,imdb_rating,description,poster) values('%s','%s',%f,'%s','%s')", 
				movie.getImdbID(), movie.getTitle(),movie.getImdbRating(), movie.getDescription(), movie.getPoster());
		
		
		
		return jdbc.executeStatement(statement->{
			int result = statement.executeUpdate(qry);
			if(result==1)
				return movie.getImdbID();
			else
				return null;
			
		});
		
		
	}
	
	
	private Movie mapMovie(ResultSet rs) throws Exception{
		Movie movie =new Movie();
		movie.setImdbID(   rs.getString("imdb_id"));
		movie.setTitle( rs.getString("title"));
		movie.setImdbRating(rs.getDouble("imdb_rating"));
		return movie;
	}
	

	@Override
	
	public Collection<Movie> getAll() {
			
		
		return jdbc.list("select * from movies", ObjectResultSetMapper.forType(Movie.class));
		
		
	}

	

	@Override
	public Movie getById(String id) {
		// TODO Auto-generated method stub
		return jdbc.single("select * from movies where imdb_id='"+id+"'", this::mapMovie);
	}

	@Override
	public void update(Movie entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		jdbc.executeStatement(stmt->{
			
			String qry=String.format("delete from movies where imdb_id="+ id);
			return stmt.executeUpdate(qry);
		});

	}
	
	

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
