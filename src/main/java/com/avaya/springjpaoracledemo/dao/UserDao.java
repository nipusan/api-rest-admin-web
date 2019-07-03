package com.avaya.springjpaoracledemo.dao;

import com.avaya.springjpaoracledemo.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
