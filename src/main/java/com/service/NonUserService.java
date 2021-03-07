package com.service;

import com.dao.UserDao;
import com.model.User;
import com.model.UserType;

public class NonUserService {

    public void saveAsUser(User user){
        UserDao userDao = new UserDao();
        userDao.save(user);
    }
}
