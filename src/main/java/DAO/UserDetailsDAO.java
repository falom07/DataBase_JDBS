package DAO;

import Entity.UserDetails;

public interface UserDetailsDAO {
    void delete(int id);
    void read_by_index(int id);
    void read_all();
    void create(UserDetails userDetails);
    void update(int id);


}
