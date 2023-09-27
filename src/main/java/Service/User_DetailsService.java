package Service;

import BusinessLogic.Utils;
import DAO.UserDetailsDAO;

import java.sql.Connection;

public class User_DetailsService extends Utils implements UserDetailsDAO {
    Connection connection = getConection();
    @Override
    public void delete(int id) {

    }
}
