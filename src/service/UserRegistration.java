package service;

import java.util.Scanner;

import model.Variables;

public class UserRegistration{
    private Scanner input;
    private Variables variable;
    private GetCity getCity;

    public UserRegistration(){
        input = new Scanner(System.in);
        variable = new Variables();
        getCity = new GetCity();
    }

    public Variables program(){       
        System.out.print("Enter username: ");
        String username = input.nextLine();
        variable.setUsername(username);
        System.out.print("Enter password: ");
        String password = input.nextLine();
        variable.setPassword(password);
        System.out.print("Enter Full Name: ");
        String name = input.nextLine();
        variable.setName(name);
        variable = getCity.program(variable);
        return variable;
    }
}