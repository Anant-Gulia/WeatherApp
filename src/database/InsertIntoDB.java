package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Variables;

public class InsertIntoDB{
    private SqlConnection sqlData;

    public void program(Variables variable){
        sqlData = new SqlConnection();
        try{
            Connection connect = sqlData.program();
            PreparedStatement write = connect.prepareStatement("INSERT INTO data (username, password, name, city, temp, conditions, log) VALUES ('"+variable.getUsername()+"', '"+variable.getPassword()+"','"+variable.getName()+"','"+variable.getCity()+"','"+variable.getTemperature()+"','"+variable.getConditions()+"','"+variable.getLog()+"')");
            write.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally{
            System.out.println("The temperature of "+variable.getCity()+" is: "+variable.getTemperature()+"C");
        }
    }
}