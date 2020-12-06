package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CreateTable{
    private SqlConnection sqlData;
    
    public CreateTable(){
        sqlData = new SqlConnection();
    }

    public void program(){
        try{
            Connection con = sqlData.program();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS data(username varchar(255) NOT NULL, password varchar(255) NOT NULL, name varchar(255) NOT NULL, city varchar(255), temp varchar(255), conditions varchar(255), log datetime PRIMARY KEY)");
            create.executeUpdate();         
        }catch(Exception e){System.out.println(e);}
    }
}