package utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcC3p0Utils {
    private static ComboPooledDataSource dataSource = null;
    static {
        try {
            // 代码配置
            // dataSource = new ComboPooledDataSource();
            // dataSource.setDriverClass("");
            // dataSource.setJdbcUrl("");
            // dataSource.setUser("");
            // dataSource.setPassword("");
            // dataSource.setMinPoolSize(10);
            // dataSource.setMaxPoolSize(15);

            // xml配置
            dataSource = new ComboPooledDataSource("MySQL");
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
