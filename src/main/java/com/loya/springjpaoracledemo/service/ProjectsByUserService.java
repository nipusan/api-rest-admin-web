package com.loya.springjpaoracledemo.service;

import com.loya.springjpaoracledemo.dao.ProjectsByUserDao;
import com.loya.springjpaoracledemo.entity.ProjectsByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsByUserService {
    @Autowired
    ProjectsByUserDao optionsByMenuDao;

    public List<ProjectsByUser> getAllProjectsByUsers() {
        return this.optionsByMenuDao.findAll();
    }

    public ProjectsByUser addProjectsByUser(ProjectsByUser user) {
        return this.optionsByMenuDao.save(user);
    }

    //other methods go here


    public Optional<ProjectsByUser> getProjectsByUserById(int id) {
        return this.optionsByMenuDao.findById(id);
    }

    public ProjectsByUser updateProjectsByUser(ProjectsByUser user) {
        return this.optionsByMenuDao.save(user);
    }

    public void deleteProjectsByUserById(int id) {
        this.optionsByMenuDao.deleteById(id);
    }

    public void deleteAllProjectsByUsers() {
        this.optionsByMenuDao.deleteAll();
    }


}
