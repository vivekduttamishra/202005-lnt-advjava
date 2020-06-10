package in.conceptarchitect.movies;

public class ImdbId {

	public static boolean isValid(String imdbID) {
		// TODO Auto-generated method stub
		return imdbID.length()>=8 && imdbID.length()<=2 && imdbID.startsWith("tt") ;
	}

}
