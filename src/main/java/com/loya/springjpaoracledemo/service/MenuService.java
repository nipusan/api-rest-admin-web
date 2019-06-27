package com.loya.springjpaoracledemo.service;

import com.loya.springjpaoracledemo.dao.MenuDao;
import com.loya.springjpaoracledemo.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    MenuDao menuDao;

    public List<Menu> getAllMenus() {
        return this.menuDao.findAll();
    }

    public Menu addMenu(Menu menu) {
        return this.menuDao.save(menu);
    }

    //other methods go here


    public Optional<Menu> getMenuById(int id) {
        return this.menuDao.findById(id);
    }

    public Menu updateMenu(Menu menu) {
        return this.menuDao.save(menu);
    }

    public void deleteMenuById(int id) {
        this.menuDao.deleteById(id);
    }

    public void deleteAllMenus() {
        this.menuDao.deleteAll();
    }


}
