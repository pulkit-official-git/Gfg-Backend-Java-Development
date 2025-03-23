package Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    public static void main(String[] args) throws SQLException {
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","oooooooo");
        Statement statement=connection.createStatement();
        statement.execute("create table jbdl(id int,count int)");
    }
}
