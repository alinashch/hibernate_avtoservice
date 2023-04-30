package BDAction.Connect;

import DI.Annotation.Injectable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

@Injectable
public class ConnectionManager {

    private final Logger logger = Logger.getLogger(ConnectionManager.class.getCanonicalName());
    private static final String DB_USERNAME="postgres";
    private static final String DB_PASSWORD="1234";
    private static final String DB_URL="jdbc:postgresql://localhost:5432/mydb";
    private DataSource dataSource;

    public ConnectionManager() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup(DB_URL);
        } catch (NamingException e) {
            logger.info("Error while JNDI name lookup. [" + e.getMessage() + "]");
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

    }
}