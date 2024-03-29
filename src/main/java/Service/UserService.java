package Service;

import BusinessLogic.Utils;
import DAO.UserDAO;
import Entity.User;
import Entity.UserDetails;

import java.sql.*;

public class UserService extends Utils implements UserDAO {
    Connection connection = getConection();
    @Override
    public void add(User user) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "Insert into user(name) value (?)";
        try  {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());

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

        String sql = "Select * from user";

        try {
            statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(sql);

            while(resultset.next()){
                System.out.print("id: " + resultset.getInt("id") + " -- ");
                System.out.println("name: " + resultset.getString("name"));
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
        String sql = "Select name from user where id = ?";
        try  {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("name by id " + id + " ->" + resultSet.getString("name"));
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
        String sql = "delete from user where id = ?";
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
    public void update(User user) throws SQLException {
        PreparedStatement preparedStatement =null;
        String sql = "Update user set name = ? where id = ?";
        try  {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2, user.getId());
            preparedStatement.setString(1, user.getName());

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













































