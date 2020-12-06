package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection{
    public Connection program(){
        try{
            String driver = "com.mysql.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/userdata";
            String username = "root";
            String password = "admin";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(URL,username,password);
            return conn;
        }catch(Exception e){System.out.println(e);}
        return null;
    }
}