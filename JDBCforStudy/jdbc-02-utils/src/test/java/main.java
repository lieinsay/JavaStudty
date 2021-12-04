import utils.JdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from `category` where `categoryid`='2'";
            connection = JdbcUtils.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println("=id===pid====name=====================================");
            while(resultSet.next()){
                System.out.println("  "+resultSet.getObject(1)+" |  "+resultSet.getObject(2)+"  | "+resultSet.getObject(3));
                System.out.println("===================================================");
            }
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.release(connection,statement,resultSet);
        }
    }
}
