package in.conceptarchitect.movies.repository.json;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieRepository;

public class MovieJsonRepository implements MovieRepository{
	
	List<Movie> movies= new ArrayList<Movie>();
	String path;
	ObjectMapper mapper=new ObjectMapper();
	
	public MovieJsonRepository(String path) {
		super();
		this.path = path;
		FileInputStream stream=null;
		try {
			stream=new FileInputStream(path);
			movies= mapper.readValue(stream ,new TypeReference<List<Movie>>() {} );
		}
		catch(Exception ex) {
			Logger.getLogger(MovieJsonRepository.class.toString()).warning("unable to read path "+path+". creating new repository");
			movies=new ArrayList<Movie>();
		}finally {
			try{stream.close();}catch(Exception ex) {}
		}
		
		
	}

	
	@Override
	public String add(Movie entity) {
		// TODO Auto-generated method stub
		movies.add(entity);
		return entity.getImdbID();
	}

	@Override
	public Collection<Movie> getAll() {
		// TODO Auto-generated method stub
		return movies;
	}

	@Override
	public Movie getById(String id) {
		// TODO Auto-generated method stub
		for(Movie movie: getAll())
			if(movie.getImdbID().equalsIgnoreCase(id))
				return movie;
		return null;
	}

	@Override
	public void update(Movie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Movie movie=getById(id);
		if(movie!=null)
			movies.remove(movie);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		FileOutputStream stream=null;
		try {
			stream=new FileOutputStream(path);
			mapper.writeValue(stream, movies);
		}catch(Exception ex) {
			Logger.getLogger(MovieJsonRepository.class.toString()).log(Level.SEVERE,"error saving the file");
			throw new RuntimeException(ex.getMessage(),ex);
			
		}finally {
			try{stream.close();}catch(Exception ex) {}
		}
	}

}
