package com.avaya.springjpaoracledemo.dao;

import com.avaya.springjpaoracledemo.entity.ProjectsByUser;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsByUserDao extends JpaRepository<ProjectsByUser, Integer> {
}
