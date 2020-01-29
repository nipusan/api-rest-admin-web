package com.avaya.proccess.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avaya.proccess.entity.User;

@Repository
public interface IUserDao  {

    User findByUsername(String username);
    List<User> getData(HashMap<String, Object> conditions);
}
