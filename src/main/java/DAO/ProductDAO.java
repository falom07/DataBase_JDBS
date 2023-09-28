package DAO;

import Entity.Product;
import Entity.User;

import java.sql.SQLException;

public interface ProductDAO {
    void add(Product product) throws SQLException;
    void getAll() throws SQLException;
    void getById(int id) throws SQLException;
    void delete( int id) throws SQLException;
    void update(Product product, int id_user) throws SQLException;

}
