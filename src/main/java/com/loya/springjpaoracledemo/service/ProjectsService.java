package com.loya.springjpaoracledemo.service;

import com.loya.springjpaoracledemo.dao.ProjectsDao;
import com.loya.springjpaoracledemo.entity.Projects;
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

    public List<Projects> getAllProjectss() {
        return this.projectsDao.findAll();
    }

    public Projects addProjects(Projects user) {
        return this.projectsDao.save(user);
    }

    //other methods go here


    public Optional<Projects> getProjectsById(int id) {
        return this.projectsDao.findById(id);
    }

    public Projects updateProjects(Projects user) {
        return this.projectsDao.save(user);
    }

    public void deleteProjectsById(int id) {
        this.projectsDao.deleteById(id);
    }

    public void deleteAllProjectss() {
        this.projectsDao.deleteAll();
    }


}
