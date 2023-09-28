package DAO;

import Entity.ChoppingCart;

import java.sql.SQLException;

public interface ChoppingaCartDAO {
    void add_one_element(ChoppingCart choppingCart) throws SQLException;
    void delete_one_element(ChoppingCart choppingCart) throws SQLException;
    void check_all_products(int id_user) throws SQLException;
    void delete_all_products(int id_user) throws SQLException;
}
