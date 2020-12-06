package service;

import java.util.Scanner;

import database.SearchDB;
import model.Variables;

public class Login{
    private SearchDB lookUp;
    private Scanner input;
    private Variables variable;
    private UserRegistration registration;

    public Login(){
        lookUp = new SearchDB();
        input = new Scanner(System.in);
        variable = new Variables();
        registration = new UserRegistration();
    }

    public Variables program(){
        int choice = 0;
        do{
            System.out.print("Enter Username: ");
            variable.setUsername(input.nextLine());
            String check = lookUp.getUserName(variable);
            if(check.equals("[false]")){
                System.out.print("Wrong input, Enter 1 to retry, 2 to go to registration page: ");
                choice = input.nextInt();
                input.nextLine();
            } else{ break; }
            if(choice == 1){
                continue;
            }else if(choice ==2 ){
                variable = registration.program();
                return variable;
            }
        }while(choice != 2);
        do{
            System.out.print("Enter Password: ");
            variable.setPassword(input.nextLine());
            String check = lookUp.getPassword(variable);
            if(check.equals("[false]")){
                System.out.print("Wrong input, Enter 1 to retry, 2 to go to registration page: ");
                choice = input.nextInt();
                input.nextLine();
            }else{ break; }
            if(choice == 1){
                continue;
            }else if(choice ==2 ){
                variable = registration.program();
                return variable;
            }
        }while(choice != 2);
        return variable;
    }
}
