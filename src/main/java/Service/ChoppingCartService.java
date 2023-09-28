package Service;

import BusinessLogic.Utils;
import DAO.ChoppingaCartDAO;
import Entity.ChoppingCart;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChoppingCartService extends Utils implements ChoppingaCartDAO {
    Connection connection = getConection();

    @Override
    public void add_one_element(ChoppingCart choppingCart) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "insert into chopping_cart (id_buyer,id_product) value (?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,choppingCart.getId_buyer());
            preparedStatement.setInt(2,choppingCart.getId_product());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

    }

    @Override
    public void delete_one_element(ChoppingCart choppingCart) throws SQLException{
        PreparedStatement preparedStatement = null;
        String sql = "delete from chopping_cart where id_buyer = ? and id_product = ? limit 1";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,choppingCart.getId_buyer());
            preparedStatement.setInt(2,choppingCart.getId_product());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }


    }

    @Override
    public void check_all_products(int id_user) throws SQLException{
        PreparedStatement preparedStatement = null;
        String sql = "Select user.name,product.product from chopping_cart\n" +
                "join user on user.id = chopping_cart.id_buyer\n" +
                "join product on chopping_cart.id_product = product.id\n" +
                "where id_buyer = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_user);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.print(resultSet.getString("product") + ",");
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void delete_all_products(int id_user) throws SQLException{
        PreparedStatement preparedStatement = null;
        String sql = "delete from chopping_cart where id_buyer = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_user);
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

    }
}
