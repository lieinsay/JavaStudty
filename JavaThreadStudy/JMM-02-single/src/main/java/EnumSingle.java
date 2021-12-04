import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum EnumSingle {
    INSTANCE;
    private Connection connection;
    Connection getConnection() {
        try {
            System.out.println("调用了MyObject构造");
            String url = "jdbc:sqlserver://localhost:1079;databaseName=ghydb";
            String username = "sa";
            String password = "";
            String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
