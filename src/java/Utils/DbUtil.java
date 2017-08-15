package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
               
                 
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            connection = DriverManager
                    .getConnection(
                            "jdbc:firebirdsql://localhost:3050/D:/FirebirdDB/TEST.fdb",
                            "sysdba", "masterkey");
            
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}