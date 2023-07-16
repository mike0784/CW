package database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    private static final String url = "jdbc:mysql://localhost:3306/human_friends?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public database() {
    }

    public boolean openDB()
    {
        // opening database connection to MySQL server
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД. Error: " + e.getMessage());
            return false;
        }
        System.out.println("База данных подключена!");
        return true;
    }

    public void queryA(String text)
    {
        try {
            stmt.execute(text);
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса\nError:" + e.getMessage());
        }
    }

    public ResultSet queryB(String text)
    {
        System.out.println(text);
        try {
            rs = stmt.executeQuery(text);
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса\nError:" + e.getMessage());
            return null;
        }
        return rs;
    }

    public void closeDB()
    {
        try {
            this.con.close();
            this.stmt.close();
            this.rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
