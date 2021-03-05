package com.dao;

import com.config.ConnectionConfiguration;
import com.model.User;
import com.model.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao implements InterfaceDao<User, String>{
    public int save(User user) {
        try{
            String sql = "insert into app_user values ('" +
                    user.getUsername() + "', '"
                    + user.getPassword() + "', " +
                    "1)";

            Statement statement = ConnectionConfiguration.getInstance().getConnection().createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public User getByPrimaryId(String username) {

        try{
            String sql = "select * from app_user where username = '" + username + "'";
            Statement statement = ConnectionConfiguration.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(!rs.next()){
                return null;
            }

            User user = new User(rs.getString(1), rs.getString(2), UserType.values()[rs.getInt(3)]);
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
}
