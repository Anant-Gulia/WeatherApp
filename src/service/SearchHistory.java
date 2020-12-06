package service;

import java.util.ArrayList;

import database.SearchDB;
import model.Variables;

public class SearchHistory{
    SearchDB lookUp;

    public SearchHistory(){
        lookUp = new SearchDB();
    }

    public void program(Variables variable){
        ArrayList<String> output = lookUp.program(variable,"*",false);
        System.out.println("Username \tPassword \t\tName \t\t\tCity \t\tTemperature \tConditions \tLog");
        for(int i=1;i<=output.size();i++){
            i--;
            System.out.print(""+output.get(i)+"\t\t");
            i++;
            if(i%7==0){
                System.out.println();
            }
        }
    }
}
