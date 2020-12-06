package model;

public class Variables {
    private String username;
    private String password;
    private String name;
    private String city;
    private double temperature; 
    private String conditions;
    private String log;
    private final String KEY = "94e25986dc2b71ed93c8f3ab653377de";
    private String URL;

    public void setCity(String temp){
        this.city=temp;
        URL = "https://api.openweathermap.org/data/2.5/weather?q=" +city+ "&appid=" +KEY+ "&units=metric";
    }
    public String getCity(){
        return this.city;
    }
    public void setUsername(String temp){
        this.username=temp;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String temp){
        this.password=temp;
    }
    public String getPassword(){
        return this.password;
    }
    public void setName(String temp){
        this.name=temp;
    }
    public String getName(){
        return this.name;
    }
    public void setTemperature(Double temp){
        this.temperature=temp;
    }
    public double getTemperature(){
        return this.temperature;
    }
    public void setConditions(String temp){
        this.conditions=temp;
    }
    public String getConditions(){
        return this.conditions;
    }
    public void setLog(String temp){
        this.log=temp;
    }
    public String getLog(){
        return this.log;
    }
    public String getKey(){
        return this.KEY;
    }
    public String getURL(){
        return this.URL;
    }
}