package com.service;

import com.dao.UserDao;
import com.model.User;
import com.model.UserType;

public class UserService {
    public User getByPrimaryId(String username){
        UserDao userDao = new UserDao();
        return userDao.getByPrimaryId(username);
    }

    public boolean userExists(String username){
        UserDao userDao = new UserDao();
        return userDao.userExists(username);
    }

    public boolean updateToCustomer(User user){
        UserDao userDao = new UserDao();
        return userDao.update(user);
    }
}
