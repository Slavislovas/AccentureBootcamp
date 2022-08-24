package Day_7.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static java.sql.Connection connection(String url){
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "");

        } catch (SQLException e){

        }
        return connection;
    }
}
