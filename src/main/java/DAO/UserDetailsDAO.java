package DAO;

import Entity.UserDetails;

import java.sql.SQLException;

public interface UserDetailsDAO {
    void delete(int id) throws SQLException;
    void read_by_index(int id) throws SQLException;
    void read_all() throws SQLException;
    void create(UserDetails userDetails) throws SQLException;
    void update(UserDetails userDetails) throws SQLException;


}
