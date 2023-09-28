package BusinessLogic;


import Entity.Order;
import Service.*;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProductService productService = new ProductService();
        productService.getAll();
    }
}
