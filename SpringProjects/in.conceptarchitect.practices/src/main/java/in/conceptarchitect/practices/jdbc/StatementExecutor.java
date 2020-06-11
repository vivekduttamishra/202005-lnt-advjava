package in.conceptarchitect.practices.jdbc;

import java.sql.Statement;


@FunctionalInterface
public interface StatementExecutor<E> {

	E executeOn(Statement statement) throws Exception;

}
