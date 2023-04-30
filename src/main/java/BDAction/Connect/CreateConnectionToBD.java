package BDAction.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnectionToBD {
    private static final String DB_USERNAME="postgres";
    private static final String DB_PASSWORD="1234";
    private static final String DB_URL="jdbc:postgresql://localhost:5432/mydb";

    public Statement createStatement() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

         return connection.createStatement();
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }
}
