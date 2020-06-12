package in.conceptarchitect.movies;

/*
 
 {
    "Title": "Harry Potter and the Deathly Hallows: Part 2",
    "Year": "2011",
    "imdbID": "tt1201607",
    "Type": "movie",
    "Poster": "/images/tt1201607.jpg",
    "imdbRating": "8.1"
},

 
  
 */

public class Movie {
	String title;
	
	String year; //may be a year range for tv shows  1999-2004
	
	String imdbID;
	
	String type;
	
	String poster;
	
	double imdbRating;
	
	String description;
	
	String tag;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Movie [imdbID=" + imdbID + ", title=" + title + ", year=" + year + ", imdbRating=" + imdbRating
				+ ", tag=" + tag + "]";
	}
	
	
}
