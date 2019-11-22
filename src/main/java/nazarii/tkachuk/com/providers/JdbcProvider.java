package nazarii.tkachuk.com.providers;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcProvider {

    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;

    private static final String HOST = PropertiesProvider.getProperty("db.host");
    private static final String PORT = PropertiesProvider.getProperty("db.port");
    private static final String DB_NAME = PropertiesProvider.getProperty("db.name");
    private static final String DB_USER = PropertiesProvider.getProperty("db.user");
    private static final String DB_PASSWORD = PropertiesProvider.getProperty("db.password");

    private JdbcProvider(){
    }

    private static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (JdbcProvider.class) {
                if (dataSource == null) {
                    dataSource = createDataSource(HOST, PORT, DB_NAME, DB_USER, DB_PASSWORD);
                }
            }
        }
        return dataSource;
    }

    private static DataSource createDataSource(String host,
                                               String port,
                                               String dbName,
                                               String dbUser,
                                               String dbPassword) {

        try {
            ComboPooledDataSource c3p0 = new ComboPooledDataSource();
            c3p0.setDriverClass("com.mysql.jdbc.Driver");
            c3p0.setJdbcUrl(String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", host, port, dbName));
            c3p0.setUser(dbUser);
            c3p0.setPassword(dbPassword);
            return c3p0;
        } catch (Exception e) {
            throw new RuntimeException("Unable to create JDBC DataSource", e);
        }
    }

    public static JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            jdbcTemplate = new JdbcTemplate(getDataSource());
        }
        return jdbcTemplate;
    }

}
