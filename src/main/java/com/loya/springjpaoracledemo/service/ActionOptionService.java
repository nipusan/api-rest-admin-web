package com.loya.springjpaoracledemo.service;

import com.loya.springjpaoracledemo.dao.ActionOptionDao;
import com.loya.springjpaoracledemo.entity.ActionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionOptionService {
    @Autowired
    ActionOptionDao actionOptionDao;

    public List<ActionOption> getAllActionOptions() {
        return this.actionOptionDao.findAll();
    }

    public ActionOption addActionOption(ActionOption actionOption) {
        return this.actionOptionDao.save(actionOption);
    }

    //other methods go here


    public Optional<ActionOption> getActionOptionById(int id) {
        return this.actionOptionDao.findById(id);
    }

    public ActionOption updateActionOption(ActionOption actionOption) {
        return this.actionOptionDao.save(actionOption);
    }

    public void deleteActionOptionById(int id) {
        this.actionOptionDao.deleteById(id);
    }

    public void deleteAllActionOptions() {
        this.actionOptionDao.deleteAll();
    }


}
