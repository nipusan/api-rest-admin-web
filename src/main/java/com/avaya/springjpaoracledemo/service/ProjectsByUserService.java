package com.avaya.springjpaoracledemo.service;

import com.avaya.springjpaoracledemo.dao.ProjectsByUserDao;
import com.avaya.springjpaoracledemo.dao.ProjectsByUserDaoImpl;
import com.avaya.springjpaoracledemo.entity.ProjectsByUser;
import com.avaya.springjpaoracledemo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectsByUserService {
    @Autowired
    ProjectsByUserDao optionsByMenuDao;
    
    @Autowired
    ProjectsByUserDaoImpl optionsByMenuDaoImpl;

    public List<ProjectsByUser> getAllProjectsByUsers() {
        return this.optionsByMenuDao.findAll();
    }

    public ProjectsByUser addProjectsByUser(ProjectsByUser user) {
        return this.optionsByMenuDao.save(user);
    }

    //other methods go here

    public List<ProjectsByUser> getProjectsByUser(int id) {
        User user = new User();
        user.setId(id);
        HashMap<String,Object> conditions = new HashMap<>();
        conditions.put("user",user);
        return this.optionsByMenuDaoImpl.getDataByUser(conditions);
    }

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
