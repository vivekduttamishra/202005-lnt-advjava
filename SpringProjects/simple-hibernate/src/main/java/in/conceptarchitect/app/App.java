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
		Session session=factory.openSession();
		
		addDummyMovies(factory,session);
		
		int choice=0;
		do {
			choice=Input.readInt("1. Add A Movie 2. List  3. Search By Id  0. exit?");
			switch(choice) {
			case 1:createMovie(factory,session); break;
			case 2: listMovies(factory,session); break;
			case 3: searchMovie(factory,session); break;
			case 0: break;
			default: System.out.println("Invalid choice. Retry"); break;
			}
			
			System.out.println("\n------\n\n");
		}while(choice!=0);
		
		if(session!=null)
			session.close();
		
		HibernateUtils.shutdown();
	}


	private static void searchMovie(SessionFactory factory, Session session) {
		// TODO Auto-generated method stub
		
		String imdbId = Input.readString("imdb id?",null);
		if(imdbId==null)
			return;	
		
		//Session session= factory.openSession();
		if(session==null) session=factory.openSession();
		
		Movie movie=session.find(Movie.class, imdbId);
		
		if(movie==null)
			System.out.println("Sorry No Such Movie");
		else
			System.out.println("You got it : "+movie);
		
	}


	private static void createMovie(SessionFactory factory, Session session) {
		// TODO Auto-generated method stub
		String dontAdd="EXIT WITHOUT ADDING A MOVIE";
		String title=Input.readString("Title",dontAdd);
		if(title.contentEquals(dontAdd))
			return;
		Movie movie=new Movie(Input.readString("imdbId"), title, Input.readInt("imdbRating"), Input.readString("details"));
		
	
		
		
		Transaction tr=null;
		
		try{
			
		//session=factory.openSession();  //you need a session
		if(session==null) session=factory.openSession();
			
		tr=session.beginTransaction();
		
		session.save(movie); //auto generates insert query
		
		
		tr.commit();   //saves all unsaved result to database by executing needed queries
		System.out.println("Movie Added");
			
		} catch(Exception ex) {
			if(tr!=null)
				tr.rollback();
			ex.printStackTrace();
		} finally {
			//session.close();
		}
		
		
		
	}
	
	private static void listMovies(SessionFactory factory, Session session2) {
		// TODO Auto-generated method stub
		Session session=null;
		try {
			//session=factory.openSession();
			if(session==null) session=factory.openSession();
			
			
			List<Movie> movies=session.createQuery(     //create a sql query based on object model
									"from Movie",       //HQL. Notice Movie is the class name not table name
									Movie.class         // and map is row in result to this class object
									).list();           // and return a list
			
			movies.forEach(System.out::println);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//session.close();
			
		}
		
	}


	private static void addDummyMovies(SessionFactory factory, Session session) {
		
		// TODO Auto-generated method stub
		if(!Input.readString("Want to add dummy movies?","y").contentEquals("y"))
			return;
		
		
		//Session session=null;
		Transaction tx=null;
		try {
			if(session==null)
				session=factory.openSession();
			if(Input.readString("do you need a transaction?","y").contentEquals("y")) {
				System.out.println("starting transaction");
				tx=session.beginTransaction();
			}
		
			session.save(createMovie("tt1230", "Harry Potter and the Order of Phonex", 6,
					"The Fifth part of harry potter saga"));
			session.save(createMovie("tt1231", "Harry Potter and the chamber of secrets", 8.2,
					"The Second part of harry potter saga"));
			
			if(Input.readString("Do you think something will go wrong?","n").contentEquals("y"))
				throw new RuntimeException("something went wrong");
			
			session.save(createMovie("tt1232", "X2", 7.5, "Part 2 of XMen series"));
			session.save(createMovie("tt1233", "XMen", 7.2, "First Part of Xmen series"));
			
			if(tx!=null) {
				tx.commit();
				System.out.println("transaction committed");
			}
		} catch(Exception ex) {
			if(tx!=null) {
				tx.rollback();
				System.out.println("transaction rolled back");
			}
			ex.printStackTrace();
		}finally {
			//if(session!=null)
			//	session.close();
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
