package DAO;

import Entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void add(User user) throws SQLException;
    void getAll() throws SQLException;
    void getById(int id) throws SQLException;
    void delete(int id) throws SQLException;
    void update(User user) throws SQLException;
}
