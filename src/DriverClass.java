import database.CreateTable;
import database.SqlConnection;
import service.Menu;

public class DriverClass {
    public static void main(String[] args){
        Menu men = new Menu();
        CreateTable createT = new CreateTable();
        SqlConnection sqlC = new SqlConnection();
        
        sqlC.program();
        createT.program();
        men.program();
    }
}