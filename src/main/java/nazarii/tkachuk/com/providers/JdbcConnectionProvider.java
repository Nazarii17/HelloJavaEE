package nazarii.tkachuk.com.providers;

import java.sql.*;
import java.sql.DriverManager;

public class JdbcConnectionProvider {

    private static final String DB_USER = PropertiesProvider.getProperty("db.user");
    private static final String DB_PASSWORD = PropertiesProvider.getProperty("db.password");
    private static final String HOST = PropertiesProvider.getProperty("db.host");
    private static final String PORT = PropertiesProvider.getProperty("db.port");
    private static final String DB_NAME = PropertiesProvider.getProperty("db.name");
//    private static final String URL = buildUrl(HOST,PORT,DB_NAME);
//    private static final String URL = buildUrl("localhost","3306","drugstoredb");

//    private static String buildUrl(String host,
//                                   String port,
//                                   String dbName){
//        return String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",host,port,dbName);
//    }

    private static Connection connection = null;

    private static PreparedStatement preparedStatement = null;

    private static Connection getConnection() {
        try {

                Class.forName("com.mysql.cj.jdbc.Driver");

//            connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/drugstoredb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/drugstoredb", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement getPreparedStation(String sql) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
