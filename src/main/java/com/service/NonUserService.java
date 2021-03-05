package com.service;

import com.dao.UserDao;
import com.model.User;

public class NonUserService {

    public void saveUser(User user){
        UserDao userDao = new UserDao();
        userDao.save(user);
    }
}
