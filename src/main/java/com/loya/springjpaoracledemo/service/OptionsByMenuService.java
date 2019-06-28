package com.loya.springjpaoracledemo.service;

import com.loya.springjpaoracledemo.dao.OptionsByMenuDao;
import com.loya.springjpaoracledemo.entity.OptionsByMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionsByMenuService {
    @Autowired
    OptionsByMenuDao optionsByMenuDao;

    public List<OptionsByMenu> getAllOptionsByMenus() {
        return this.optionsByMenuDao.findAll();
    }

    public OptionsByMenu addOptionsByMenu(OptionsByMenu user) {
        return this.optionsByMenuDao.save(user);
    }

    //other methods go here


    public Optional<OptionsByMenu> getOptionsByMenuById(int id) {
        return this.optionsByMenuDao.findById(id);
    }

    public OptionsByMenu updateOptionsByMenu(OptionsByMenu user) {
        return this.optionsByMenuDao.save(user);
    }

    public void deleteOptionsByMenuById(int id) {
        this.optionsByMenuDao.deleteById(id);
    }

    public void deleteAllOptionsByMenus() {
        this.optionsByMenuDao.deleteAll();
    }


}
