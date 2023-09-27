package Service;

import BusinessLogic.Utils;
import DAO.UserDetailsDAO;
import Entity.UserDetails;

import java.sql.Connection;

public class User_DetailsService extends Utils implements UserDetailsDAO {
    Connection connection = getConection();
    @Override
    public void delete(int id) {

    }

    @Override
    public void read_by_index(int id) {

    }

    @Override
    public void read_all() {

    }

    @Override
    public void create(UserDetails userDetails) {

    }



    @Override
    public void update(int id) {

    }
}
