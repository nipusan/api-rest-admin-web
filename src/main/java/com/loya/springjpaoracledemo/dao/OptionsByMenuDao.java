package com.loya.springjpaoracledemo.dao;

import com.loya.springjpaoracledemo.entity.OptionsByMenu;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsByMenuDao extends JpaRepository<OptionsByMenu, Integer> {
}
