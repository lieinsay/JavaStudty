import java.sql.*;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 用户信息和url
        String url="jdbc:mysql://localhost:3306/school?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=true";
        String user="root";
        String password="153573zyw";

        // 3. 连接成功，数据库对象Connection代表数据库
        Connection connection = DriverManager.getConnection(url, user, password);

        // 4. 执行SQL的对象Statement执行SQL的对象
        Statement statement = connection.createStatement();
//        PreparedStatement preparedStatement = connection.prepareStatement();

        // 5. 执行SQL的对象去执行SQL，可能存在结果，查看返回结果
        String sql = "select * from `category`";
        ResultSet resultSet = statement.executeQuery(sql);

        // 6. 查询结果
        while(resultSet.next()){
            System.out.println(resultSet.getObject(1));
            System.out.println(resultSet.getObject(2));
            System.out.println(resultSet.getObject(3));
        }

        // 7. 释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}