package org.example;

import Service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserService();
//        User user = new User();
//        user.setName("Віка");
//        user.setId(110);
        userService.getById(2);
    }
}