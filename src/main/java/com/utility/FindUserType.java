package com.utility;

import com.dao.UserDao;
import com.model.User;
import com.model.UserType;

public class FindUserType {
    private User user;

    public UserType getUserType(String username){
        UserDao userDao = new UserDao();
        return userDao.getUserType(username);
    }

    public boolean isEmployee(String username, String password){
        return false;
    }

    public boolean isCustomer(String username, String password){
        return false;
    }

    public boolean isUser(String username, String password){
        return false;
    }

    public boolean isNotUser(String username, String password){
        return false;
    }
}
