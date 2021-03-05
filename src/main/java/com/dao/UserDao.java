package com.dao;

import com.config.ConnectionConfiguration;
import com.model.User;

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

    public User getByPrimaryId(String id) {
        return null;
    }

    public boolean remove(String id) {
        return false;
    }

    public boolean update(User user) {
        return false;
    }
}
