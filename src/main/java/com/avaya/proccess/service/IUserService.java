package com.avaya.proccess.service;


import java.util.HashMap;
import java.util.List;

import com.avaya.proccess.dto.UserDto;
import com.avaya.proccess.entity.User;

public interface IUserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
    
    List<User> getData(HashMap<String, Object> conditions);
}
