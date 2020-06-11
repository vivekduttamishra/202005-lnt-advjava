package in.conceptarchitect.practices.jdbc;

import java.sql.ResultSet;

public interface ResultSetMapper<E> {

	E map(ResultSet rs) throws Exception;

}
