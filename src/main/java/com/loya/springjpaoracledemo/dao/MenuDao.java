package com.loya.springjpaoracledemo.dao;

import com.loya.springjpaoracledemo.entity.Menu;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao extends JpaRepository<Menu, Integer> {
}
