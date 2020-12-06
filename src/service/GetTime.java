package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import database.InsertIntoDB;
import model.Variables;

public class GetTime{
    private InsertIntoDB insert;
    
    public void program(Variables var){
        insert = new InsertIntoDB();
        Calendar date = Calendar.getInstance();
        SimpleDateFormat log = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        var.setLog( log.format(date.getTime()) );
        insert.program(var);
    }
}