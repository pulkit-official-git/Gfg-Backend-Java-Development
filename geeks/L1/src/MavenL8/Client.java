package MavenL8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

    public static void main(String[] args) throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/test","root","oooooooo");
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","oooooooo");
        Statement statement = connection.createStatement();
        statement.execute("create table dummy(id int,count int)");

    }
}
