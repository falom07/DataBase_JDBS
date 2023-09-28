package DAO;

import java.sql.SQLException;

public interface OrderDAO {
    public void take_all_order() throws SQLException;
    public void take_order_by_id(int id_user) throws SQLException;
    public void keep_order(int id_user) throws SQLException;

}
