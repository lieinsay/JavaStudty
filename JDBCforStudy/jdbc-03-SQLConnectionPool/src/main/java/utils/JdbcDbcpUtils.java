package utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDbcpUtils {
    private static DataSource dataSource = null;
    static {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(in);
            // 创建数据源 工厂模式——>创建
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // 从DBCP数据池中获取连接
        return dataSource.getConnection();
    }

//    public static void release(Connection connection, Statement statement, ResultSet resultSet){
//        try {
//            if(resultSet!=null)
//                resultSet.close();
//            if(statement!=null)
//                statement.close();
//            if(connection!=null)
//                connection.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

}
