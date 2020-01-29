package com.avaya.proccess.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.avaya.proccess.dto.UserDto;
import com.avaya.proccess.entity.User;
import com.avaya.proccess.model.ApiResponse;
import com.avaya.proccess.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ApiResponse<User> saveUser(@RequestBody UserDto user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @RequestMapping(value="/signin", method = RequestMethod.POST)
    public ApiResponse<User> signin(@RequestBody UserDto user){
    	HashMap<String, Object> conditions = new HashMap<String, Object>();
    	conditions.put("username", user.getUsername());
    	conditions.put("password", user.getPassword());
    	List<User> userList = userService.getData(conditions);
    	if (userList != null) {
    		for (User item : userList) {
    			return new ApiResponse<>(HttpStatus.OK.value(), "Login successfully.", item);    						
			}
    	}
    	return new ApiResponse<>(HttpStatus.OK.value(), "Login failed.", null);    						
    	
    	
    	
    	
    	
    	
//    	User userResponse = userService.findOne(user.getUsername());
//    	if (userResponse != null) {
//    		if (userResponse.getPassword().equals(user.getPassword())) {
//    			return new ApiResponse<>(HttpStatus.OK.value(), "Login successfully.", userResponse);    		
//    		}    		
//    	} else {
//    		return new ApiResponse<>(HttpStatus.OK.value(), "invalid user",null);    		    		
//    	}
//    	return new ApiResponse<>(HttpStatus.OK.value(), "invalid password",null);    		
    }

    @GetMapping
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
