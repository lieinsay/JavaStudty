import utils.JdbcC3p0Utils;
import utils.JdbcDbcpUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from `category`";
            connection = JdbcC3p0Utils.getConnection();

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
//            JdbcUtils.release(connection,statement,resultSet);
        }
    }
}
