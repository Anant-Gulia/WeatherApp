package api;

import java.io.*;
import java.net.*;

import model.Variables;

public class ApiConnection{
    private HttpURLConnection connection;
    private ParseData parse;
    private BufferedReader reader;
    private String line;
    private StringBuffer responseContent;

    public ApiConnection(){
        parse = new ParseData();
        responseContent = new StringBuffer();
    }
    
    public void program(Variables var){
        try{
            URL url=new URL(var.getURL());
            connection=(HttpURLConnection) url.openConnection();

            //Request Setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status=connection.getResponseCode();
 
            if(status>=300){
                reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line=reader.readLine()) != null)
                    responseContent.append(line);
                reader.close();
            }else{
                reader =new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line=reader.readLine()) != null)
                    responseContent.append(line);
                reader.close();
            }
            parse.program(responseContent.toString(),var);
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            connection.disconnect();
        }
    }
}