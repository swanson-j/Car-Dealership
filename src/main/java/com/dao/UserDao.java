package com.dao;

import com.config.ConnectionConfiguration;
import com.model.User;
import com.model.UserType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao implements InterfaceDao<User, String>{
    public int save(User user) {
        try{
            String sql = "insert into app_user values (?, ?, 1)";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int i = preparedStatement.executeUpdate();
            System.out.println("The number of updated rows were " + i);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public User getByPrimaryId(String username) {

        try{
            String sql = "select * from app_user where username = ?";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                return null;
            }

            User user = new User(resultSet.getString(1), resultSet.getString(2), UserType.values()[resultSet.getInt(3)]);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean remove(String id) {
        return false;
    }

    public boolean update(User user) {
        return false;
    }

    // using prepared statement with custom stored function
    public boolean userExists(String username){
        try{
            String sql = "select car_dealership.userExists(?)";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return resultSet.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // TODO: get UserType associated with a user
    public UserType getUserType(String username){
        try{
            String sql = "select car_dealership.userType(?)";
            PreparedStatement preparedStatement = ConnectionConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return UserType.valueOf(resultSet.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
