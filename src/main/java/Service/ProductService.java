package Service;

import BusinessLogic.Utils;
import DAO.ProductDAO;
import Entity.Product;
import Entity.User;

import java.sql.*;

public class ProductService extends Utils implements ProductDAO {
    Connection connection = getConection();
    @Override
    public void add(Product product) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Insert into product(product,price,detail_information) value (?,?,?)";
        try  {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getProduct());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getDetail_information());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void getAll() throws SQLException{
        Statement statement = null;

        String sql = "Select * from product";

        try {
            statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);

            while(resultset.next()){
                System.out.print("product name: " + resultset.getString("product") + " -- ");
                System.out.print("price: " + resultset.getInt("price"));
                System.out.println(" -- detail_information: " + resultset.getString("detail_information"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        if (statement != null) {
            statement.close();
        }
        if(connection != null){
            connection.close();
        }
    }

    @Override
    public void getById(int id) throws SQLException{
        PreparedStatement preparedStatement = null;
        String sql = "Select product,price,detail_information from product where id = ?";
        try  {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                System.out.print("product name: " + resultset.getInt("product") + " -- ");
                System.out.println("price: " + resultset.getString("price"));
                System.out.println("detail_information: " + resultset.getString("detail_information"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public void delete( int id) throws SQLException{

        PreparedStatement preparedStatement = null;
        String sql = "delete from product where id = ?";
        try  {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void update(Product product,int id_user) throws SQLException {
        PreparedStatement preparedStatement =null;
        String sql = "Update user set product = ? ,price = ? ,detail_information = ? where id = ?";
        try  {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2,product.getPrice() );
            preparedStatement.setInt(4,id_user );
            preparedStatement.setString(1,product.getProduct() );
            preparedStatement.setString(3,product.getDetail_information() );

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}
