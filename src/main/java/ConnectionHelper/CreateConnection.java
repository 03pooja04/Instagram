package ConnectionHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnection {
    public static Connection createconnection()
    {
        Connection con;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","pooja123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
