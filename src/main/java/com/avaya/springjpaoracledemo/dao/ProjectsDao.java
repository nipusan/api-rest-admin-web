package com.avaya.springjpaoracledemo.dao;

import com.avaya.springjpaoracledemo.entity.Project;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsDao extends JpaRepository<Project, Integer> {
}
