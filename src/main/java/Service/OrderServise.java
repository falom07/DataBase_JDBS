package Service;

import BusinessLogic.Utils;
import DAO.OrderDAO;
import Entity.Order;

import java.sql.*;

public class OrderServise extends Utils implements OrderDAO {
    Connection connection = getConection();
    @Override
    public void take_all_order() throws SQLException {
        Statement statement = null;
        String sql = "Select id_user, product, price,user.name from orders\n" +
                "join user on orders.id_user = user.id\n" +
                "order by id_user";
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("id_user") +  ": |" + resultSet.getString("user.name") + " |  products : " + resultSet.getString("product") + " | price: " + resultSet.getInt("price") + "\n");
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        } finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void take_order_by_id(int id_user) throws SQLException {
        PreparedStatement statement = null;
        String sql = "Select id_user, product, price,user.name from orders\n" +
                "join user on orders.id_user = user.id\n" +
                "where id_user = ? limit 1 ";
        try{
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id_user);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("id_user") +  ": |" + resultSet.getString("user.name") + " |  products : " + resultSet.getString("product") + " | price: " + resultSet.getInt("price") + "\n");
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        } finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void keep_order(int id_user) throws SQLException {
        Order all_info = take_all_products(id_user);
        delete_all_products(id_user);

        PreparedStatement preparedStatement = null;
        String sql = "Insert into orders (id_user,product,price) value (?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,all_info.getId_user());
            preparedStatement.setString(2, all_info.getProduct());
            preparedStatement.setInt(3,all_info.getPrice());


            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
    }

    public Order take_all_products(int id_user) throws SQLException{
        Order order = new Order();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT id_buyer,product.price,product.product from chopping_cart join product on chopping_cart.id_product = product.id\n" +
                "                                              where chopping_cart.id_buyer = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_user);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                order.setProduct(order.getProduct() + "," + resultSet.getString("product.product"));
                order.setPrice(order.getPrice() + resultSet.getInt("product.price"));

            }
            order.setId_user(id_user);
            System.out.println("list product: " + order.getProduct());
            System.out.println("price: " + order.getPrice());
            System.out.println("id_user: " + order.getId_user());

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
        }
        return order;
    }
    public void delete_all_products (int id_user) throws SQLException{
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
        }
    }
}
