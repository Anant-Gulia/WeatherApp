package database;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Variables;

public class SearchDB{
    private SqlConnection sqlData;

    public SearchDB(){
        sqlData = new SqlConnection();
    }

    public ArrayList<String> program(Variables variable, String type, boolean noHistory){
        ArrayList<String> array = new ArrayList<String>();
        PreparedStatement statement;

        try{
            Connection connect = sqlData.program();
            if(noHistory){
                statement = connect.prepareStatement("SELECT username,password,name FROM data");
            }else{
                statement = connect.prepareStatement("SELECT * FROM data WHERE username = '"+variable.getUsername()+"'");
            }
            
            ResultSet result = statement.executeQuery();
            boolean flag = true;
            while(result.next()){
                if(noHistory){
                    if(result.getString("username").equals(variable.getUsername())){
                        array.add("true");
                        flag = false;
                        if(type.equals("password")){
                            if(!result.getString("password").equals(variable.getPassword())){
                                array.remove(0);
                                array.add("false");
                            }
                        }else if(type.equals("name")){
                                array.remove(0);
                                array.add(result.getString("name"));
                        }
                        return array;
                    }
                }else{
                    for(int i=1;i<=7;i++){
                        array.add(result.getString(i));
                    }
                }
            }
            if(noHistory){
                if(flag){
                    array.add("false");
                }
            }
            return array;
                //array.add(result.getString(type));
        }catch(Exception e){System.out.println(e);}
        return null;
    }
    public String getUserName(Variables var){
        return program(var,"username",true).toString();
    }
    public String getPassword(Variables var){
        return program(var,"password",true).toString();
    }
    public ArrayList<String> getName(Variables var){
        return program(var,"name",true);
    }
}
