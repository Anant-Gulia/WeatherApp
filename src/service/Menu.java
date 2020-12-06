package service;

import java.util.Scanner;

import database.SearchDB;
import model.Variables;

import java.util.ArrayList;

public class Menu{
    private Variables variable;
    private Scanner input;
    private UserRegistration registration;
    private Login login;
    private SearchHistory history;
    private GetCity getCity;
    private SearchDB search;

    public Menu(){
        variable = new Variables();
        input = new Scanner(System.in);
        registration = new UserRegistration();
        login = new Login();
        history = new SearchHistory();
        getCity = new GetCity();
        search = new SearchDB();
    }

    public void program(){
        System.out.println("1. Login");
        System.out.println("2. Register");
        int choice=0;
        do{
            choice = input.nextInt();
            switch(choice){
                case 1: variable=login.program();
                        ArrayList<String> name = search.getName(variable);
                        variable.setName(name.get(0));
                        break;
                case 2: variable=registration.program();
                        break;
                default: System.out.println("Wrong input, enter again");
                        break;
            }
        }while(choice!= 1 && choice!=2);
        input.nextLine(); //Clear Buffer
        do{
            System.out.println("Enter 1 to display search history");
            System.out.println("Enter 2 to get temperature");
            System.out.println("Enter 3 to Exit");
            choice = input.nextInt();
            switch(choice){
                case 1: history.program(variable);
                        break;
                case 2: variable=getCity.program(variable);
                        break; 
                case 3: System.exit(0);
                        break;
                default: System.out.println("Wrong input, enter again");
                        break;
            }
            input.nextLine(); //Clear Buffer
        }while(choice != 3);
    }
}