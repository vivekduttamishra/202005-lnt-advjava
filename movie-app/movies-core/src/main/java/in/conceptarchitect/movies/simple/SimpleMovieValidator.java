

package in.conceptarchitect.movies.simple;

import java.util.Collection;
import java.util.HashMap;

import in.conceptarchitect.movies.ImdbId;
import in.conceptarchitect.movies.Movie;
import in.conceptarchitect.movies.MovieValidator;
import in.conceptarchitect.practices.ValidationMessage;

public class SimpleMovieValidator implements MovieValidator{

	@Override
	public ValidationMessage validate(Movie item) {
		// TODO Auto-generated method stub
		ValidationMessage validation=new ValidationMessage();
		
		validation
			.addErrorOnNullOrEmpty(item.getImdbID(), "imdbId"	, "Missing Imdb Id")
			.addErrorOnNullOrEmpty(item.getTitle(), "title", "Missing Movie Title")
			.addErrorOnNullOrEmpty(!ImdbId.isValid(item.getImdbID()), "imdbId", "Invalid ImdbId");
			
			
				
		
		
		return validation;
	}

	
	
}
