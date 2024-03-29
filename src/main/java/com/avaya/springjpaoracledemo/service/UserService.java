package com.avaya.springjpaoracledemo.service;

import com.avaya.springjpaoracledemo.dao.UserDao;
import com.avaya.springjpaoracledemo.dao.UserDaoImpl;
import com.avaya.springjpaoracledemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserDao userDao;
    
    @Autowired
    UserDaoImpl userDaoImpl;

    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    public User addUser(User user) {
        return this.userDao.save(user);
    }

    public List<User> login(User user) {
        HashMap<String,Object> conditions = new HashMap<>();
        conditions.put("username",user.getUsername());
        conditions.put("password",user.getPassword());
        return this.userDaoImpl.getData(conditions);
    }

    //other methods go here

    public Optional<User> getUserById(int id) {
        return this.userDao.findById(id);
    }

    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    public void deleteUserById(int id) {
        this.userDao.deleteById(id);
    }

    public void deleteAllUsers() {
        this.userDao.deleteAll();
    }


}
