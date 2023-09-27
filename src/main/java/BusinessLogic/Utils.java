package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    private static final String BD_User = "sammy";
    private static final String BD_Password = "Password123#@!";
    private static final String BD_URL = "jdbc:mysql://localhost:3306/Shop?useUnicode=true&serverTimezone=UTC";

    public Connection getConection(){
        Connection connection;
        try{

             connection =  DriverManager.getConnection(BD_URL,BD_User,BD_Password);
            System.out.println("Connection ok");
        }catch (SQLException exception){
            System.out.println("Connection ERROR");
            throw new RuntimeException(exception);
        }
        return connection;
    }
}
