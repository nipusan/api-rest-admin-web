package com.avaya.springjpaoracledemo.dao;

import com.avaya.springjpaoracledemo.entity.OptionsByMenu;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsByMenuDao extends JpaRepository<OptionsByMenu, Integer> {
}
