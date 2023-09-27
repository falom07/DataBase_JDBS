package BusinessLogic;


import Service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
        userService.getById(1);

    }
}
