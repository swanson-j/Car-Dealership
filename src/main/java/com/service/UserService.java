package com.service;

import com.dao.UserDao;
import com.model.User;
import com.model.UserType;

public class UserService {
    public User getByPrimaryId(String username){
        UserDao userDao = new UserDao();
        return userDao.getByPrimaryId(username);
    }
}
