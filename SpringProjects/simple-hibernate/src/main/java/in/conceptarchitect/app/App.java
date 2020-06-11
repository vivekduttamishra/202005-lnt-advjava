package in.conceptarchitect.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.conceptarchitect.movies.entities.Movie;
import in.conceptarchitect.utils.HibernateUtils;
import in.conceptarchitect.utils.Input;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=HibernateUtils.getSessionFactory();
		
		addDummyMovies(factory);
		
		//createMovie(factory);
		
		listMovies(factory);
		
		HibernateUtils.shutdown();
	}


	private static void createMovie(SessionFactory factory) {
		// TODO Auto-generated method stub
		String dontAdd="EXIT WITHOUT ADDING A MOVIE";
		String title=Input.readString("Title",dontAdd);
		if(title.contentEquals(dontAdd))
			return;
		Movie movie=new Movie(Input.readString("imdbId"), title, Input.readInt("imdbRating"), Input.readString("details"));
		
	
		
		
		Transaction tr=null;
		Session session=null;
		try{
			
		session=factory.openSession();  //you need a session
		tr=session.beginTransaction();
		
		session.save(movie); //auto generates insert query
		
		
		tr.commit();   //saves all unsaved result to database by executing needed queries
		System.out.println("Movie Added");
			
		} catch(Exception ex) {
			if(tr!=null)
				tr.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		
		
	}
	
	private static void listMovies(SessionFactory factory) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			session=factory.openSession();
			
			
			List<Movie> movies=session.createQuery(     //create a sql query based on object model
									"from Movie",       //HQL. Notice Movie is the class name not table name
									Movie.class         // and map is row in result to this class object
									).list();           // and return a list
			
			movies.forEach(System.out::println);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			session.close();
			
		}
		
	}


	private static void addDummyMovies(SessionFactory factory) {
		
		// TODO Auto-generated method stub
		if(!Input.readString("Want to add dummy movies?").contentEquals("y"))
			return;
		
		
		Session session=null;
		Transaction tx=null;
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
		
			session.save(createMovie("tt1230", "Harry Potter and the Order of Phonex", 6,
					"The Fifth part of harry potter saga"));
			session.save(createMovie("tt1231", "Harry Potter and the chamber of secrets", 8.2,
					"The Second part of harry potter saga"));
			session.save(createMovie("tt1232", "X2", 7.5, "Part 2 of XMen series"));
			session.save(createMovie("tt1233", "XMen", 7.2, "First Part of Xmen series"));

			tx.commit();
		} catch(Exception ex) {
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}

		
	}

	static Movie createMovie(String imdbId, String title, double rating, String description) {
		Movie movie = new Movie();
		movie.setImdbId(imdbId);
		movie.setTitle(title);
		movie.setImdbRating(rating);
		movie.setDetails(description);
		return movie;
	}

	
	
	
}
