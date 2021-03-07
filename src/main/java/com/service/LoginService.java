package com.service;

import com.dao.UserDao;
import com.model.User;

//First two methods no longer used but kept for documentation

public class LoginService {
    public boolean userExists(String userName){
        UserDao userDao = new UserDao();
        return userDao.userExists(userName);
    }

    public boolean isPasswordCorrect(User user){
        UserDao userDao = new UserDao();
        User databaseUser = userDao.getByPrimaryId(user.getUsername());
        if(user.getPassword().equals(databaseUser.getPassword())){
            return true;
        } else {
            return false;
        }
    }

    public User getUserByCredentials(String username, String password){
        UserDao userDao = new UserDao();
        return userDao.getByCredentials(username, password);
    }
}
