package com.avaya.springjpaoracledemo.dao;

import com.avaya.springjpaoracledemo.entity.ActionOption;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionOptionDao extends JpaRepository<ActionOption, Integer> {
}
