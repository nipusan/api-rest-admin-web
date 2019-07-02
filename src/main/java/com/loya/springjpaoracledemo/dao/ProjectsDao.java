package com.loya.springjpaoracledemo.dao;

import com.loya.springjpaoracledemo.entity.Projects;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsDao extends JpaRepository<Projects, Integer> {
}
