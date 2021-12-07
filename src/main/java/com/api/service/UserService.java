package com.api.service;

import com.api.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User get(String id) {
        return userDao.get(id);
    }

    public String insert(User user) {
        userDao.insert(user);
        return "Insert ID: "+user.getId()+" OK!";
    }

}
