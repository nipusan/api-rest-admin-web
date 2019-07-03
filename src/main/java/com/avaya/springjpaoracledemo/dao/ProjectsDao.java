package com.avaya.springjpaoracledemo.dao;

import com.avaya.springjpaoracledemo.entity.Projects;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsDao extends JpaRepository<Projects, Integer> {
}
