package spbpu.auction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfing {

    private static String hostname = "localhost:5432";
    private static String dbName = "auction";
    private static String userName = "postgres";
    private static String password = "root";

    @Bean
    public static Connection connection() {
        String connectionURL = "jdbc:postgresql://" +
                hostname + "/" + dbName;

        try {
            return DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
