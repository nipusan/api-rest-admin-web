package com.loya.springjpaoracledemo.dao;

import com.loya.springjpaoracledemo.entity.OptionMenu;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionMenuDao extends JpaRepository<OptionMenu, Integer> {
}
