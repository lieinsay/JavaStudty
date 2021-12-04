package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String  username = null;
    private static String  password = null;
    static {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet!=null)
                resultSet.close();
            if(statement!=null)
                statement.close();
            if(connection!=null)
                connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
