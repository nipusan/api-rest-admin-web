package com.loya.springjpaoracledemo.dao;

import com.loya.springjpaoracledemo.entity.ProjectsByUser;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsByUserDao extends JpaRepository<ProjectsByUser, Integer> {
}
