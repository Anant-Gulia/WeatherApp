package service;

import java.util.Scanner;

import api.ApiConnection;
import model.Variables;

public class GetCity{
    private Scanner input;
    private ApiConnection apiConnect;

    public GetCity(){
        input = new Scanner(System.in);
        apiConnect = new ApiConnection();
    }

    public Variables program(Variables variable){
        System.out.print("Enter city name: ");
        String city = input.nextLine();
        variable.setCity(city);
        apiConnect.program(variable);
        return variable;
    }
}
