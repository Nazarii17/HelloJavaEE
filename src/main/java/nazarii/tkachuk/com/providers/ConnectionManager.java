package nazarii.tkachuk.com.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection ==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/drugstoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            } catch ( ClassNotFoundException | SQLException e ){
                e.printStackTrace();
            }
        }
        return connection;
    }
}
