package Service;

import BusinessLogic.Utils;
import DAO.UserDetailsDAO;
import Entity.UserDetails;
import jdk.jshell.spi.SPIResolutionException;

import java.sql.*;

public class User_DetailsService extends Utils implements UserDetailsDAO {
    Connection connection = getConection();


    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Delete from user_details where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void read_by_index(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT user.name as name,age,address,phone from user_details join user on user.id = user_details.id  where user.id = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("name: " + resultSet.getString("name") + "\nage " + resultSet.getInt("age") +
                      "\naddress " + resultSet.getString("address") + "\nphone " + resultSet.getString("phone") );
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void read_all() throws SQLException {
        Statement statement = null;
        String sql = "SELECT user.name as name,age,address,phone from user_details join user on user.id = user_details.id";
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("name: " + resultSet.getString("name") + "\nage " + resultSet.getInt("age") +
                        "\naddress " + resultSet.getString("address") + "\nphone " + resultSet.getString("phone") + "\n");
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void create(UserDetails userDetails) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "insert into user_details (id, age, address, phone) values (?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(3,userDetails.getAddress());
            preparedStatement.setString(4,userDetails.getPhone());
            preparedStatement.setInt(2,userDetails.getAge());
            preparedStatement.setInt(1,userDetails.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            if(preparedStatement != null)
                preparedStatement.close();
        }if(connection != null){
            connection.close();
        }
    }

    @Override
    public void update(UserDetails userDetails) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Update user_details set age = ?,address = ?,phone = ? where id = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2,userDetails.getAddress());
            preparedStatement.setString(3,userDetails.getPhone());
            preparedStatement.setInt(1,userDetails.getAge());
            preparedStatement.setInt(4,userDetails.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            if(preparedStatement != null)
                preparedStatement.close();
        }if(connection != null){
            connection.close();
        }
    }
}

