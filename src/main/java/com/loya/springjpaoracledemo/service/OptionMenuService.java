package com.loya.springjpaoracledemo.service;

import com.loya.springjpaoracledemo.dao.OptionMenuDao;
import com.loya.springjpaoracledemo.entity.OptionMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionMenuService {
    @Autowired
    OptionMenuDao optionMenuDao;

    public List<OptionMenu> getAllOptionMenus() {
        return this.optionMenuDao.findAll();
    }

    public OptionMenu addOptionMenu(OptionMenu user) {
        return this.optionMenuDao.save(user);
    }

    //other methods go here


    public Optional<OptionMenu> getOptionMenuById(int id) {
        return this.optionMenuDao.findById(id);
    }

    public OptionMenu updateOptionMenu(OptionMenu user) {
        return this.optionMenuDao.save(user);
    }

    public void deleteOptionMenuById(int id) {
        this.optionMenuDao.deleteById(id);
    }

    public void deleteAllOptionMenus() {
        this.optionMenuDao.deleteAll();
    }


}
