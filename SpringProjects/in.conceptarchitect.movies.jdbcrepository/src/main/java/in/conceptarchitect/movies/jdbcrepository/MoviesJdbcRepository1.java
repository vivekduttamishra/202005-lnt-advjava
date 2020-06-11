package in.conceptarchitect.movies.jdbcrepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieRepository;
import in.conceptarchitect.practices.jdbc.SqlRuntimeException;

//@Repository("moviesRepository")
public class MoviesJdbcRepository1 implements MovieRepository {

	String connectionString;
	String userName;
	String password;

	




	public MoviesJdbcRepository1(String connectionString, String userName, String password) {
		super();
		this.connectionString = connectionString;
		this.userName = userName;
		this.password = password;
		
	}
	
	
	

	public String getConnectionString() {
		return connectionString;
	}




	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public MoviesJdbcRepository1() {
		super();
	}




	@Override
	public String add(Movie movie) {
		// TODO Auto-generated method stub
		Connection con=null;
		try{
			
		
			con= DriverManager.getConnection(connectionString,userName, password);
			
			Statement statement=con.createStatement();
			
			
			String qry= String.format("insert into movies(imdb_id,title,imdb_rating,description,poster) values('%s','%s',%f,'%s','%s')", 
					movie.getImdbID(), movie.getTitle(),movie.getImdbRating(), movie.getDescription(), movie.getPoster());
			
			
			int rowEffected= statement.executeUpdate(qry);
			
			
			if(rowEffected==1)
				return movie.getImdbID();
			else
				return null;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SqlRuntimeException(e.getMessage(),e);
		} finally{
		
			try{
				if(con!=null)
					con.close();
			} catch(SQLException e) {
				System.out.println("FATAL ERROR: SQL Exception in close");
				e.printStackTrace();
				throw new SqlRuntimeException(e.getMessage(),e);
			}
		}
		
		
		

	}
	
	

	@Override
	public Collection<Movie> getAll() {
		List<Movie> movies=new ArrayList<Movie>();
		Connection con=null;
		try{
			
			//Older Jdbc Spec -- before requesting for a connection, we must register our driver
			//method #1
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//method #2 -- auto registers if class is loaded
			//Class.forName("com.mysql.jdbc.Driver");
			
			//New Convention
			//Any Jdbc Driver present in classpath (includding maven dependnecy) are 
			//automaticaly registered to DriverManager
		
			con= DriverManager.getConnection(connectionString,userName, password);
			
			Statement statement=con.createStatement();
			
			ResultSet results= statement.executeQuery("select * from movies");
			
			
			
			while(results.next()){
			
				Movie movie =new Movie();
				movie.setImdbID(   results.getString("imdb_id"));
				movie.setTitle( results.getString("title"));
				movie.setImdbRating(results.getDouble("imdb_rating"));
				
				movies.add(movie);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SqlRuntimeException(e.getMessage(),e);
		} finally{
		
			try{
				if(con!=null)
					con.close();
			} catch(SQLException e) {
				System.out.println("FATAL ERROR: SQL Exception in close");
				e.printStackTrace();
				throw new SqlRuntimeException(e.getMessage(),e);
			}
		}
		
		return movies;

	}

	

	@Override
	public Movie getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Movie entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
