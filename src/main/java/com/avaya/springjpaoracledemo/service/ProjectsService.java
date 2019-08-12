package com.avaya.springjpaoracledemo.service;

import com.avaya.springjpaoracledemo.dao.ProjectsDao;
import com.avaya.springjpaoracledemo.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {
    @Autowired 
    ProjectsDao projectsDao;

    public List<Project> getAllProjectss() {
        return this.projectsDao.findAll();
    }

    public Project addProjects(Project user) {
        return this.projectsDao.save(user);
    }

    //other methods go here


    public Optional<Project> getProjectsById(int id) {
        return this.projectsDao.findById(id);
    }

    public Project updateProjects(Project user) {
        return this.projectsDao.save(user);
    }

    public void deleteProjectsById(int id) {
        this.projectsDao.deleteById(id);
    }

    public void deleteAllProjectss() {
        this.projectsDao.deleteAll();
    }


}
