package in.conceptarchitect.practices.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcManager {

	String connectionString;
	String username;
	String password;
	
	
	
	public JdbcManager(String connectionString, String username, String password) {
		super();
		this.connectionString = connectionString;
		this.username = username;
		this.password = password;
	}
	
	
	public <E> E executeStatement(StatementExecutor<E> statementExecutor) {
		
		Connection con=null;
		
		try {
			con=DriverManager.getConnection(connectionString,username,password);
			
			Statement statement=con.createStatement();
			
			//we need to execute the query on the statement
			return statementExecutor.executeOn(statement);
			
			
		} catch(Exception ex) {
			throw new SqlRuntimeException(ex.getMessage(), ex);
		} finally {
			
			try {
				if(con!=null)
					con.close();
			}catch(Exception ex) {
				throw new SqlRuntimeException(ex.getMessage(), ex);
			}
		}
		
		
	}
	
	
	
	public <E> List<E>  list(String qry, ResultSetMapper<E> mapper){
		
		return executeStatement(stmt-> {
			
			ArrayList<E> result=new ArrayList<E>();
			
			ResultSet rs= stmt.executeQuery(qry);
	
			while(rs.next()) {
				
				E object= mapper.map(rs);
				
				result.add(object);
			}
			
			return result;
		});
		
	}

	public <E> E  single(String qry, ResultSetMapper<E> mapper){
		
		return executeStatement(stmt-> {
			
			ArrayList<E> result=new ArrayList<E>();
			
			ResultSet rs= stmt.executeQuery(qry);
	
			if(rs.next()) {
				
				return mapper.map(rs);
				
			} else
			
				return null;
		});
		
	}

	

}
